package Algorithms_The_Book;

public class Linked_Queue {

    private Node first;
    private Node last;

    private class Node {
        private Comparable item;
        private Node next;
    }

    public boolean isEmpty() { return first == null; }

    public void add(Comparable value)
    {
        Node old_last_node = last;      //save the link to the last node

        last = new Node();              //create a new node
        last.item = value;
        last.next = null;

        if (isEmpty())                      //when the queue is empty, first and last nodes
        { first = last; }                   //will point to the same node
        else
        { old_last_node.next = last; }

    }

    public Comparable remove()
    {
        Comparable temp_item = first.item;
        first = first.next;                     //delete the first node from the queue

        if (isEmpty())
        { last = null; }                        //if the queue is empty, first=null and last=null

        return temp_item;
    }

}
