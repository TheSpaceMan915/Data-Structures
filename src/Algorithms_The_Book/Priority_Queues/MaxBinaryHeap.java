package Algorithms_The_Book.Priority_Queues;

public class MaxBinaryHeap {
    //finish HeapSort

    private Comparable[] m_arr;
    private int m_size;
    private int lastChanged;

    public MaxBinaryHeap(int size)
    { m_arr = new Comparable[size + 1]; }

    public MaxBinaryHeap(Comparable[] arr, int size)
    {
        m_arr = new Comparable[size + 1];

        //add elements using the insert method, so we'll have a properly built binary heap
        for (int j = 0; j < arr.length; j++)
        { insert(arr[j]); }

    }

    public boolean isEmpty()
    {return m_size == 0; }

    public int size()
    { return m_size; }

    public void PrintHeap()
    {
        for (int i = 1; i <= m_size; i++)
        {
            System.out.print(m_arr[i] + " ");
        }
        System.out.println();
    }

    private boolean less(int value1, int value2)
    { return m_arr[value1].compareTo(m_arr[value2]) < 0; }

    private void exch(int ind1,int ind2)
    {
        Comparable temp = m_arr[ind1];
        m_arr[ind1] = m_arr[ind2];
        m_arr[ind2] = temp;
    }

    public void swim(int k)             //go from the bottom to the root of the heap
    {
        while (k > 1 && less(k/2,k))    //while it's not root and parent is smaller than its child
        {
            exch(k/2,k);                //put child above its parent
            k = k/2;
        }
    }

    public void sink(int k)                     //go from root to the bottom
    {
        while (2*k <= m_size)                   //while it's not the last element of the heap
        {                                       //and child is bigger than the parent
            int j = 2*k;
            if (less(j,j+1) && j < m_size)
                { j++; }
            if (!less(k,j))                 //if the child is smaller that its parent
                { break; }                  //exit the function

            exch(k,j);                      //put parent below its child
            k = j;
        }
    }

    public void insert(Comparable value)
    {
        m_arr[++m_size] = value;
        swim(m_size);
    }

    //add DeleteMax function

    public static void main(String[] args) {

        Comparable[] test_arr1 = {18,9,12,23,17,14,32};
        MaxBinaryHeap heap = new MaxBinaryHeap(30);

        for (Comparable val : test_arr1)
        { heap.insert(val);}

        heap.PrintHeap();
    }
}
