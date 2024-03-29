package lab7_Queue;

public class Test_Fixed_Capacity_Queue {

    private Comparable[] m_arr;
    private int m_size;
    private int m_head;
    private int m_tail;

    public Test_Fixed_Capacity_Queue(int size)
    {
        m_size = size;
        m_arr = new Comparable[size];
    }

    public boolean isEmpty() { return m_tail == 0; }

    public void add(Comparable value)
    {
        if (m_tail < m_size)                    //add elements to the end of the queue
        { m_arr[m_tail++] = value; }
        else
        {                                       //if the queue is bigger than its size
            m_head = 0;                         //zero head and tail and start adding elements
            m_tail = 0;                         //to the beginning as if the queue is empty
            m_arr[m_tail++] = value;
        }
    }

    public Comparable remove()
    {
        if (isEmpty())                 //if there are initially no elements in the queue,return null pointer
        { return null; }
        else if (m_head == m_tail)     //if all the elements from the queue have been removed
        {                              //set the head and the tail to the beginning of the queue
            m_head = 0;
            m_tail = 0;
            return null;
        }
        else                                            //otherwise, get arr[m_head] element and
        {                                               //increment m_head
            Comparable temp_value = m_arr[m_head++];
            return temp_value;
        }
    }

    public void PrintQueue()
    {
        int arr_size = m_tail - m_head;
        Comparable[] temp_arr = new Comparable[arr_size];
        Comparable temp;

        System.out.println("Here is your queue:");
        for (int i = 0; i < arr_size; i++)
        {
            temp = remove();
            System.out.println(temp);
            temp_arr[i] = temp;
        }

        for (Comparable value : temp_arr)
        { add(value); }
    }

    public static void main(String[] args) {

        Test_Fixed_Capacity_Queue queue = new Test_Fixed_Capacity_Queue(10);

        queue.add(2);
        queue.add(1);
       //queue.PrintQueue();
       queue.add(5);
       queue.add(54);
       queue.PrintQueue();
    }
}
