package Algorithms_The_Book;

public class Fixed_Capacity_Stack {

    private Comparable arr[];
    private int m_size;
    private Comparable lastPushed;

    public Fixed_Capacity_Stack(int size)
    { arr = new Comparable[size]; }

    public boolean isEmpty() { return m_size == 0; }

    public int size() { return m_size; }

    public void push(Comparable elem)
    { arr[m_size++] =elem; }

    public Comparable pop()
    { return arr[--m_size]; }
}
