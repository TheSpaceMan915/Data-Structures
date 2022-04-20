package lab4_Sorting_Algorithms;

import java.util.concurrent.ThreadLocalRandom;

public class Drive_Sorting {

    static private int m_iteration_number;
    static private int m_comparison_number;
    static private int m_swap_number;
    static private long m_start_time;
    static private long m_end_time;
    static private double m_duration;

    static {
        m_iteration_number = 0;
        m_comparison_number = 0;
        m_swap_number = 0;
        m_start_time = 0;
        m_end_time = 0;
        m_duration = 0;
    }

    //Templates for sort algorithms
    private static boolean less(Comparable value1, Comparable value2)
    {
        m_comparison_number++;
        return value1.compareTo(value2) < 0;
    }

    private static void exch(Comparable arr[],int ind1,int ind2)
    {
        m_swap_number++;
        Comparable temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    public static void PrintArray(Comparable arr[])
    {
        for (Comparable value : arr)
        {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    static void ShuffleArray(Comparable[] ar)
    {
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = ThreadLocalRandom.current().nextInt(i + 1);
            // Simple swap
            Comparable a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

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

    public static void ZeroAllCounters()
    {
        m_iteration_number = 0;
        m_comparison_number = 0;
        m_swap_number = 0;
    }

    public static void BubbleSort(Comparable[] arr)
    {
        m_start_time = System.nanoTime();
        ZeroAllCounters();

        int i = arr.length - 1;
        boolean flag = false;

        while (i > 0)
        {
            int k = 0;
            m_iteration_number++;
            while (k < i)
            {
                if (less(arr[k+1],arr[k]))
                {
                    exch(arr,k+1,k);
                    flag = true;
                }
                k++;
            }
            if (flag == false)          //Iverson's condition
            {break;}
            i--;
        }
        m_end_time = System.nanoTime();
        m_duration = (double) (m_end_time - m_start_time)/1000000000;   //to get time in seconds
    }

    public static void quicksort(Comparable[] arr)
    {
        m_start_time = System.nanoTime();
        ZeroAllCounters();

        qs(arr, 0, arr.length - 1);

        m_end_time = System.nanoTime();
        m_duration = (double) (m_end_time - m_start_time)/1000000000;   //to get time in seconds
    }

    public static void qs(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);

        qs(arr, l, p - 1);
        qs(arr, p + 1, r);
    }

    public static int partition(Comparable[] arr, int l, int r) {
        Comparable pivot = arr[r];
        int i = l - 1;
        m_iteration_number++;

        for (int j = l; j < r; j++) {

            if (less(arr[j],pivot))
            {
                i++;
                exch(arr,i,j);
            }
        }
        exch(arr,i+1,r);
        return i + 1;
    }
    //_______________________________________

    public static void SelectionSort(Comparable[] arr)
    {
        m_start_time = System.nanoTime();
        ZeroAllCounters();

        int min_ind = 0;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++)
        {
            min_ind = i;
            m_iteration_number++;
            for (int j = i + 1; j < arr.length;j++)
            {
                if (less(arr[j],arr[min_ind]))
                {min_ind = j;}
            }
            exch(arr,i,min_ind);
        }

        m_end_time = System.nanoTime();
        m_duration = (double) (m_end_time - m_start_time)/1000000000;   //to get time in seconds
    }

    public static void InsertionSort(Comparable[] arr)
    {
        m_start_time = System.nanoTime();
        ZeroAllCounters();

        for (int i = 1; i < arr.length; i++)
        {
            m_iteration_number++;

            for ( int j = i; j > 0; j--)
            {
                if (less(arr[j],arr[j-1]))
                {
                    exch(arr,j,j-1);
                }
            }
        }

        m_end_time = System.nanoTime();
        m_duration = (double) (m_end_time - m_start_time)/1000000000;   //to get time in seconds
    }


    public static void main(String[] args) {

        System.out.println("BubbleSort");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%25s %25s %25s %25s %25s","Array size","Duration, seconds","Iteration number","Swap number","Comparison number");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        Comparable[] arr_20 = CreateArray(20);
        Comparable[] arr_500 = CreateArray(500);
        Comparable[] arr_1000 = CreateArray(1000);
        Comparable[] arr_3000 = CreateArray(3000);
        Comparable[] arr_5000 = CreateArray(5000);
        Comparable[] arr_10000 = CreateArray(10000);

        BubbleSort(arr_20);
        System.out.printf("%25s %25f %25s %25s %25s",arr_20.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number);
        System.out.println();

        BubbleSort(arr_500);
        System.out.printf("%25s %25f %25s %25s %25s",arr_500.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        BubbleSort(arr_1000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_1000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        BubbleSort(arr_3000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_3000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        BubbleSort(arr_5000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_5000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        BubbleSort(arr_10000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_10000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        //Test the next sorting algorithm
        ShuffleArray(arr_20);
        ShuffleArray(arr_500);
        ShuffleArray(arr_1000);
        ShuffleArray(arr_3000);
        ShuffleArray(arr_5000);
        ShuffleArray(arr_10000);

        System.out.println("SelectionSort");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%25s %25s %25s %25s %25s","Array size","Duration, seconds","Iteration number","Swap number","Comparison number");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        SelectionSort(arr_20);
        System.out.printf("%25s %25f %25s %25s %25s",arr_20.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number);
        System.out.println();

        SelectionSort(arr_500);
        System.out.printf("%25s %25f %25s %25s %25s",arr_500.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        SelectionSort(arr_1000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_1000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        SelectionSort(arr_3000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_3000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        SelectionSort(arr_5000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_5000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        SelectionSort(arr_10000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_10000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        //Test the next sorting algorithm
        ShuffleArray(arr_20);
        ShuffleArray(arr_500);
        ShuffleArray(arr_1000);
        ShuffleArray(arr_3000);
        ShuffleArray(arr_5000);
        ShuffleArray(arr_10000);

        System.out.println("InsertionSort");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%25s %25s %25s %25s %25s","Array size","Duration, seconds","Iteration number","Swap number","Comparison number");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        InsertionSort(arr_20);
        System.out.printf("%25s %25f %25s %25s %25s",arr_20.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number);
        System.out.println();

        InsertionSort(arr_500);
        System.out.printf("%25s %25f %25s %25s %25s",arr_500.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        InsertionSort(arr_1000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_1000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        InsertionSort(arr_3000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_3000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        InsertionSort(arr_5000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_5000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        InsertionSort(arr_10000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_10000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        //_______________________________________
        //Test the next sorting algorithm
        ShuffleArray(arr_20);
        ShuffleArray(arr_500);
        ShuffleArray(arr_1000);
        ShuffleArray(arr_3000);
        ShuffleArray(arr_5000);
        ShuffleArray(arr_10000);

        System.out.println("QuickSort");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%25s %25s %25s %25s %25s","Array size","Duration, seconds","Iteration number","Swap number","Comparison number");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        quicksort(arr_20);
        System.out.printf("%25s %25f %25s %25s %25s",arr_20.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number);
        System.out.println();

        quicksort(arr_500);
        System.out.printf("%25s %25f %25s %25s %25s",arr_500.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        quicksort(arr_1000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_1000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        quicksort(arr_3000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_3000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        quicksort(arr_5000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_5000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        quicksort(arr_10000);
        System.out.printf("%25s %25f %25s %25s %25s",arr_10000.length,m_duration,m_iteration_number,m_swap_number,m_comparison_number );
        System.out.println();

        //if we've got 20 - 3000 elements, we should use straight sorting algorithms
        //if we've got 5000 elements or more , we should use QuickSort
    }
}
