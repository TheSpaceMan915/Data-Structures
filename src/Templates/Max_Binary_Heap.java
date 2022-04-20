package Templates;

public class Max_Binary_Heap {

    private Comparable[] m_arr;
    private int m_size = 0;


    public Max_Binary_Heap() {}

    public Max_Binary_Heap(int N)
    { m_arr = new Comparable[N + 1]; }

    public Max_Binary_Heap(Comparable[] arr)
    {
        m_arr = new Comparable[arr.length + 1];

        //add elements using the insert method, so the heap will be sorted after it's been created
        /*for (Comparable value : arr)
        {
            insert(value);
        }*/

        for (int i = 0; i < arr.length; i++)
        {
            m_arr[++m_size] = arr[i];
        }
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

    public void swim(int i)             //go from the bottom to the root of the heap
    {
        while (i > 1 && less(i/2,i))    //while it's not root and parent is smaller than its child
        {
            exch(i/2,i);                //put child above its parent
            i = i/2;
        }
    }

    public void sink(int i)         //go from root to the bottom
    {
        while (2*i <= m_size)                   //while it's not the last element of the heap
        {                                    //and child is bigger than the parent
            int j = 2*i;
            if (less(j,j+1) && j < m_size)
            { j++; }
            if (!less(j,i))             //if the child is smaller that its parent
            { break; }                  //exit the function

            exch(i,j);                      //put parent below its child
            i = j;
        }
    }

    public void insert(Comparable value)
    {
        m_arr[++m_size] = value;
        swim(m_size);
    }

    public static void main(String[] args) {

        Comparable[] test_arr1 = {8,9,10,11,12,13,14};
        Max_Binary_Heap heap = new Max_Binary_Heap(test_arr1);
        heap.PrintHeap();
    }
}
