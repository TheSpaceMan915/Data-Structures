package lab5_Linear_And_Binary_Search;

import java.util.concurrent.ThreadLocalRandom;

public class Drive_Search {

    private static int m_start_time = 0;
    private static int m_end_time = 0;
    private static int m_comparison_time = 0;
    private static int m_duration = 0;

    public static Comparable[] CreateArray(int arr_size)
    {

        Comparable numbers_arr[] = new Comparable[arr_size];
        int rand = 0;
        int min_value = -10000, max_value = 10000;

        for (int i = 0;i< numbers_arr.length;i++)
        {
            rand = ThreadLocalRandom.current().nextInt(min_value,max_value + 1);
            numbers_arr[i] = rand;
        }

        return numbers_arr;
    }
    public static int LinearSearch(int elem, Comparable arr[])
    {
        int i = 0;
        int elem_ind = -1;
        while (i < arr.length)
        {
            if (arr[i].equals(elem))
            {
                elem_ind = i;
                break;
            }
            else
            { i++; }
        }

        return elem_ind;
    }



    public static void main(String[] args) {

        Comparable[] ints_arr = { 3,4,-3,5,6,11};
        int test_elem = 11;
        int ind = LinearSearch(test_elem,ints_arr);
        System.out.println(ind);

    }

    }

