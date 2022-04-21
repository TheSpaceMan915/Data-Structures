package lab6_Stack;

//linked stack
//another version of stack should be with a static array
//Count elements and insert elements in the end of the array   arr[n+1] = elem
public class Test_Linked_Stack {

    private Node m_first;
    private int m_size = 0;

    private class Node {
       private Comparable item;
       private Node next;
    }

    public boolean isEmpty() { return m_size == 0;}

    public int size() { return m_size; }

    public void push(Comparable elem)
    {
        Node old_first_elem = m_first;      //save the old first

        m_first = new Node();               //create a new pointer

        m_first.item = elem;
        m_first.next = old_first_elem;            //connect the new first and the old one
        m_size++;
    }

    public Comparable pop()
    {
        Comparable temp_item = m_first.item;        //save the item to be returned

        m_first = m_first.next;                 //change the pointer to the next element in the stack
        m_size--;

        return temp_item;
    }

    public void PrintStack()
    {
        Comparable temp_arr[] = new Comparable[m_size];
        Comparable temp;

        System.out.println("Here is your stack:");
        for (int i = 0; i < temp_arr.length; i++)           //pop all elements from the stack
        {
            temp = pop();
            System.out.println(temp);
            temp_arr[i] = temp;                             //and save them in the array
        }

        for (int j = temp_arr.length - 1; j >= 0; j--)
        {
            push(temp_arr[j]);                              //push the elements back in the stack
        }
    }

    public static void main(String[] args) {

        Test_Linked_Stack stack = new Test_Linked_Stack();

        stack.push(4);
        stack.push(11);
        stack.push(65);

        stack.PrintStack();
        stack.push(4);
    }
}
