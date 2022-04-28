package Templates;

public class Doubly_Linked_List<Item> {

    private Node m_head = null;

    private int m_current_items_number = 0;

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

    public void insertItemAfter(Item obj,Node previous)
    {
        Node new_node = new Node();
        new_node.m_item = obj;

        new_node.m_next = previous.m_next;           // connect a new node with the node that the previous one pointed to
        previous.m_next = new_node;                //connect the previous node with a new node

        new_node.m_prev = previous;               //connect a new node with the previous one

        if (new_node.m_next != null)
        { new_node.m_next.m_prev = new_node; }      //connect a new node with the node after it
    }

    public static void main(String[] args) {

        Doubly_Linked_List<Integer> list_obj = new Doubly_Linked_List<>();

        list_obj.addItemAtTheFront(32);
        list_obj.addItemAtTheFront(54);


        System.out.println("Check");
    }
}
