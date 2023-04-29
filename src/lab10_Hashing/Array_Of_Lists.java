package lab10_Hashing;
import java.util.LinkedList;

public class Array_Of_Lists<Item extends Comparable<Item>> {

    private LinkedList<Item>[] m_arr_lists;
    private int[] m_keys;               //contains hash values.Each one corresponds to the linked list
                                        //at the same position

    public Array_Of_Lists(int size)
    {
        m_arr_lists = (LinkedList<Item>[]) new LinkedList[size];
        m_keys = new int[size];

        for (int k = 0; k < size; k++)
        { m_arr_lists[k] = new LinkedList<>(); }

        for (int j = 0; j < size; j++)
        { m_keys[j] = j; }
    }

    public void addElem(int key, Item item)
    {
        if (key < m_keys.length)
        { m_arr_lists[key].add(item); }
        else
        { System.out.println("The index should be less than " + m_keys.length); }
    }

    //find the index of the Item in the linked list
    public int findElem(int key,Item item)
    {
        int ind = -1;
        if (key < m_keys.length)
        {
            if (m_arr_lists[key].contains(item))
            { ind = m_arr_lists[key].indexOf(item); }
            else
            { System.out.println("There is no such element in the list");}
        }
        else
        { System.out.println("The index should be less than " + m_keys.length); }

        return ind;
    }

    public void printList(int key)
    {
        Object[] arr = m_arr_lists[key].toArray();
        for (Object elem : arr)
        {
            System.out.print(elem + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        final int size = 5;
        Array_Of_Lists<Double> arr_obj = new Array_Of_Lists(size);

        arr_obj.addElem(0,65.3);
        arr_obj.addElem(0,4322.5);
        arr_obj.addElem(1,135.32);
        arr_obj.addElem(1,675.32);
        arr_obj.addElem(1,905.35);
        arr_obj.printList(0);
        arr_obj.printList(1);

        Double elem_to_be_found = 4322.5;
        int ind1 = arr_obj.findElem(0,elem_to_be_found);
        System.out.println("The index of the element " + elem_to_be_found + " is " + ind1);
    }
}
