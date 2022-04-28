package lab7_Queue;

public class Test_Linked_Queue {

    private Node m_first;
    private Node m_last;
    private int m_size = 0;

    private class Node {
        private Comparable item;
        private Node next;
    }

    public boolean isEmpty() { return m_first == null; }

    public void add(Comparable value)
    {
        Node old_last_node = m_last;      //save the link to the last node

        m_last = new Node();              //create a new node
        m_last.item = value;
        m_last.next = null;
        m_size++;

        if (isEmpty())                      //when the queue is empty, first and last nodes
        { m_first = m_last; }                   //will point to the same node
        else
        { old_last_node.next = m_last; }

    }

    public Comparable remove()
    {
        Comparable temp_item = null;

        if (!isEmpty())
        {
            temp_item = m_first.item;
            m_first = m_first.next;
            m_size--;
        }
        else
        { m_last = null; }

        return temp_item;
    }

    public void PrintQueue()
    {
        if (isEmpty())
        {
            System.out.println("Your queue is empty");
        }
        else
        {
            int present_size = m_size;

            Comparable[] temp_arr = new Comparable[present_size];
            Comparable temp;

            System.out.println("Here is your queue:");
            for (int i = 0; i < present_size; i++) {
                temp = remove();
                temp_arr[i] = temp;
                System.out.println(temp);
            }

            for (Comparable value : temp_arr) {
                add(value);
            }
        }
    }

    public static void main(String[] args) {

        Test_Linked_Queue queue = new Test_Linked_Queue();

        queue.add(20);
        queue.add(8);
        queue.add(52);
        queue.add(54);

        System.out.println("State 1");
        queue.PrintQueue();

        System.out.println("State 2");
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.PrintQueue();

        System.out.println("State 3");
        queue.add(20);
        queue.add(8);
        queue.PrintQueue();

    }
}
