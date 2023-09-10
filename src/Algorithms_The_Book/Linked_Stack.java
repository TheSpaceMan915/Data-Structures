package Algorithms_The_Book;

public class Linked_Stack {

    private Node m_first;
    private int m_size = 0;
    private Node last;

    private class Node {
       private Comparable item;
       private Node next;
    }

    public boolean isEmpty() { return m_size == 0;}

    public int size() { return m_size; }

    public void push(Comparable elem)
    {
        Node old_first_node = m_first;      //save the old first

        m_first = new Node();               //create a new pointer

        m_first.item = elem;
        m_first.next = old_first_node;            //connect the new first and the old one
        m_size++;
    }

    public Comparable pop()
    {
        Comparable temp_item = m_first.item;        //save the item to be returned

        m_first = m_first.next;                 //change the pointer to the next element in the stack
        m_size--;

        return temp_item;
    }

    public static void main(String[] args) {


    }
}
