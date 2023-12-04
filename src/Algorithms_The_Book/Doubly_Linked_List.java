package Algorithms_The_Book;

public class Doubly_Linked_List<Item> {

    private Node m_head;
    private int m_current_items_number;
    private int maxNumberNodes;

    public class Node
    {
       private Item m_item;
       private Node m_next;
       private Node m_prev;
    }

    public void addItemAtTheFront(Item obj)
    {
        m_current_items_number++;
        Node temp = new Node();
        temp.m_item = obj;
        temp.m_next = m_head;        //a new node points to head
        temp.m_prev = null;

        if( m_head != null)
        { m_head.m_prev = temp; }     //head points to a new node

        m_head = temp;             //make a new node the head
    }

    //The function inserts an item after a certain node
    /*
    public void insertItemAfter(Item obj,Node previous)
    {
        Node new_node = new Node();
        new_node.m_item = obj;

        new_node.m_next = previous.m_next;           // connect a new node with the node that the previous one pointed to
        previous.m_next = new_node;                //connect the previous node with a new node

        new_node.m_prev = previous;               //connect a new node with the previous one

        if (new_node.m_next != null)
        { new_node.m_next.m_prev = new_node; }      //connect a new node with the node after it
    }*/

    public void insert(Item obj, int pos)
    {
        Node new_node = new Node();
        new_node.m_item = obj;

        if (pos < 1)
        { System.out.println("You can't insert the element at this position. Try again"); }
        else if (pos == 1)
        {
            new_node.m_next = m_head;       //make an added element the head
            m_head.m_prev = new_node;       //because we add at the first position in the list
            m_head = new_node;
        }
        else
        {
            Node previous = m_head;

            for (int i = 1; i < pos - 1; i++)       //iterate to the node previous to the position
            { previous = previous.m_next; }

            new_node.m_next = previous.m_next;              // connect a new node with the node that the previous one pointed to

            if (new_node.m_next != null)
            { previous.m_next.m_prev = new_node; }          //connect a new node with the node after it

            new_node.m_prev = previous;                     //connect a new node with the previous one
            previous.m_next = new_node;                     //connect the previous node with a new node
        }
    }

    public void delete(int pos)
    {

        if (pos < 1)
        { System.out.println("You can't delete the element at this position. Try again"); }
        else if (pos == 1 && m_head != null)
        {
           Node old_head = m_head;          //save the old head
           m_head = m_head.m_next;

           old_head = null;                 //delete the old head
           if (m_head != null)
           { m_head.m_prev = null; }
        }
        else
        {
            Node previous = m_head;

            for (int i = 1; i < pos - 1; i++)
            { previous = previous.m_next; }


            previous.m_next = previous.m_next.m_next;       //connect the notes before and after the deleting note

            previous.m_next.m_prev = previous;            //connect the note after the position with the one before
        }
    }

    public static void main(String[] args) {

        Doubly_Linked_List<Integer> list_obj = new Doubly_Linked_List<>();

        list_obj.addItemAtTheFront(32);
        list_obj.addItemAtTheFront(54);
        list_obj.insert(90,2);
        list_obj.delete(2);


        System.out.println("Check");
    }
}
