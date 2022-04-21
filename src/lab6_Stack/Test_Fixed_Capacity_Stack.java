package lab6_Stack;

public class Test_Fixed_Capacity_Stack {

    private Comparable m_arr[];
    private int m_size = 0;

    public Test_Fixed_Capacity_Stack(int size)
    { m_arr = new Comparable[size]; }

    public boolean isEmpty() { return m_size == 0; }

    public int size() { return m_size; }

    public void push(Comparable elem)
    { m_arr[m_size++] =elem; }

    public Comparable pop()
    { return m_arr[--m_size]; }

    public void PrintStack()
    {
        Comparable temp_arr[] = new Comparable[m_size];
        Comparable temp;

        System.out.println("Here is your stack:");
        for (int i = 0; i < temp_arr.length; i++)
        {
            temp = pop();
            System.out.println(temp);
            temp_arr[i] = temp;
        }

        for (int j = temp_arr.length- 1; j >= 0; j--)
        {
            push(temp_arr[j]);
        }
    }

    public static void main(String[] args) {

        final int stack_size = 30;
        Test_Fixed_Capacity_Stack stack = new Test_Fixed_Capacity_Stack(stack_size);

        stack.push(76);
        stack.push(54);
        stack.push(5);

        stack.PrintStack();
        stack.push(4);
        System.out.println("Cf");
    }
}
