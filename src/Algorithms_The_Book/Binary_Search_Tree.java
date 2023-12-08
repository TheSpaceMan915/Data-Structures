package Algorithms_The_Book;

public class Binary_Search_Tree<Key extends Comparable<Key>,Item> {

    private Node m_root;
    private int level;
    
    private class Node
    {
        Key m_key;
        Item m_item;
        Node m_left;
        Node m_right;

        public Node(Key key, Item item)
        {
            m_key = key;
            m_item = item;
        }
    }

    public Item get(Key key_obj)
    {
        Node temp = m_root;

        while (temp != null)
        {
            int comp_value = key_obj.compareTo(temp.m_key);

            if (comp_value < 0) temp = temp.m_left;         //if key_obj less than the key in the node, go to the left subtree
            if (comp_value > 0) temp = temp.m_right;        //if key_obj greater than the key in the node, go to the right subtree
            else return temp.m_item;
        }

        return null;            //if the Item is not in the tree,return null
    }

    public void add(Key key, Item item)
    { m_root = add(m_root,key,item); }              //set the root

    private Node add(Node node_obj, Key key_obj,Item item_obj)
    {
        if (node_obj == null)                                   //if there is no node at the position,
        { return new Node(key_obj,item_obj); }              //create one

        int comp_value = key_obj.compareTo(node_obj.m_key);             //otherwise,go to the position
        if (comp_value < 0)                                         //where the node with the key
        { node_obj.m_left = add(node_obj.m_left, key_obj, item_obj); }      //should be and create a node there
        else if (comp_value > 0)
        { node_obj.m_right = add(node_obj.m_right, key_obj, item_obj); }
        else
        { node_obj.m_item = item_obj; }         //if there is the node with this key just put Item in the node

        return node_obj;                        //return a new root with changed subtrees
    }

    public Key min()
    {
        Key temp_key = min(m_root).m_key;
        return temp_key;
    }

    private Node min(Node node_obj)              //function to find the min (the lowest node) in the tree
    {
        if (node_obj.m_left == null)
        { return node_obj; }
        else
        { return min(node_obj.m_left); }
    }

    public void deleteMin()
    { m_root = deleteMin(m_root); }

    private Node deleteMin(Node node_obj)
    {
        if (node_obj.m_left == null)
        { return node_obj.m_right; }
        else
        {
            node_obj.m_left = deleteMin(node_obj.m_left);
            return node_obj;
        }
    }

    public void delete(Key key)
    { m_root = delete(m_root,key); }

    private Node delete(Node node_obj, Key key_obj)
    {
        if (node_obj == null) return null;

        int comp_value = key_obj.compareTo(node_obj.m_key);
        if (comp_value < 0)
        { node_obj.m_left = delete(node_obj.m_left,key_obj); }
        else if (comp_value > 0)
        { node_obj.m_right = delete(node_obj.m_right,key_obj); }
        else
        {
            if (node_obj.m_right == null)
            { return null; }
            if (node_obj.m_left == null)
            { return null; }

            Node temp = node_obj;                               //save the position of deleting node
            node_obj = min(temp.m_right);                       //find the node X containing the min key
            node_obj.m_right = deleteMin(temp.m_right);         //make the node X.right point to the subtree with larger keys
            node_obj.m_left = temp.m_left;                      //make the node X.left point to the subtree with lesser keys
        }
        return node_obj;                                        //reset the root
    }

    public void print() { print(m_root); }

    private void print(Node node)
    {
        if (node == null)
        { return; }

        System.out.printf("%s ",node.m_item + "\t");
        print(node.m_left);
        print(node.m_right);
    }

    public static void main(String[] args) {

        Binary_Search_Tree<Integer,String> tree_obj = new Binary_Search_Tree<>();

        tree_obj.add(50,"Hello");
        tree_obj.add(40,"How");
        tree_obj.add(38,"Are");
        tree_obj.add(41,"You");
        tree_obj.add(60,"Doing");

        tree_obj.print();
        System.out.println();
        tree_obj.delete(41);
        tree_obj.print();
    }
    }
