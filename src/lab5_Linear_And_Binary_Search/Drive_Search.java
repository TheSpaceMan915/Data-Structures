package lab5_Linear_And_Binary_Search;
import java.util.concurrent.ThreadLocalRandom;

public class Drive_Search {

    private static long m_start_time = 0;
    private static long m_end_time = 0;
    private static int m_comparison_number = 0;
    private static double m_duration = 0;

    private static int m_iteration_number = 0;

    private static boolean less(Comparable value1, Comparable value2)
    {
        return value1.compareTo(value2) < 0;
    }

    private static void exch(Comparable arr[],int ind1,int ind2)
    {
        Comparable temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    public static Comparable[] CreateArray(int arr_size)
    {

        Comparable numbers_arr[] = new Comparable[arr_size];
        int rand = 0;
        int min_value = -1000, max_value = 1000;

        for (int i = 0;i< numbers_arr.length;i++)
        {
            rand = ThreadLocalRandom.current().nextInt(min_value,max_value + 1);
            numbers_arr[i] = rand;
        }

        return numbers_arr;
    }

    public static void ZeroCounters()
    {

        m_comparison_number = 0;
        m_iteration_number = 0;
    }

    public static void quicksort(Comparable[] arr) { qs(arr, 0, arr.length - 1); }

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

    public static int LinearSearch(int elem, Comparable arr[])
    {
        m_start_time = System.nanoTime();
        ZeroCounters();

        int i = 0;
        int elem_ind = -1;
        while (i < arr.length)
        {
            m_iteration_number++;
            m_comparison_number++;
            if (arr[i].equals(elem))
            {
                elem_ind = i;
                break;
            }
            else
            { i++; }
        }

        m_end_time = System.nanoTime();
        m_duration = (double) (m_end_time - m_start_time)/1000000000;
        return elem_ind;
    }

    public static int BinarySearch(int elem, Comparable arr[]) {

        m_start_time = System.nanoTime();
        ZeroCounters();

        int elem_ind = -1;
        int L = 0;
        int R = arr.length - 1;

        while (L < R)
        {
            m_iteration_number++;
            int merid = L + (R - L) / 2;

            if (less(elem,arr[merid]))
            { R = merid - 1; }
            else if (less(arr[merid],elem))
            { L = merid + 1; }
            else
            {
                elem_ind = merid;
                break;
            }
        }

        m_end_time = System.nanoTime();
        m_duration = (double) (m_end_time - m_start_time)/1000000000;
        return elem_ind;
    }
    public static void main(String[] args) {

        System.out.println("№1______________________________________________________________________________");
        Comparable[] arr1_100 = CreateArray(100);
        Comparable[] arr2_100 = CreateArray(100);
        Comparable[] arr3_100 = CreateArray(100);
        Comparable[] arr1_500 = CreateArray(500);
        Comparable[] arr2_500 = CreateArray(500);
        Comparable[] arr3_500 = CreateArray(500);
        Comparable[] arr1_1000 = CreateArray(1000);
        Comparable[] arr2_1000 = CreateArray(1000);
        Comparable[] arr3_1000 = CreateArray(1000);
        Comparable[] arr1_3000 = CreateArray(3000);
        Comparable[] arr2_3000 = CreateArray(3000);
        Comparable[] arr3_3000 = CreateArray(3000);
        Comparable[] arr1_10000 = CreateArray(10000);
        Comparable[] arr2_10000 = CreateArray(10000);
        Comparable[] arr3_10000 = CreateArray(10000);
        int test_elem = 7;

        System.out.println("Linear search in an unsorted array");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%25s %25s %25s","Array size","Duration, seconds","Comparison number");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        int ind_elem1 = LinearSearch(test_elem,arr1_100);
        System.out.printf("%25s %25f %25s",arr1_100.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem2 = LinearSearch(test_elem,arr2_100);
        System.out.printf("%25s %25f %25s",arr1_100.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem3 = LinearSearch(test_elem,arr3_100);
        System.out.printf("%25s %25f %25s",arr1_100.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem4 = LinearSearch(test_elem,arr1_500);
        System.out.printf("%25s %25f %25s",arr1_500.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem5 = LinearSearch(test_elem,arr2_500);
        System.out.printf("%25s %25f %25s",arr2_500.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem6 = LinearSearch(test_elem,arr3_500);
        System.out.printf("%25s %25f %25s",arr3_500.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem7 = LinearSearch(test_elem,arr1_1000);
        System.out.printf("%25s %25f %25s",arr1_1000.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem8 = LinearSearch(test_elem,arr2_1000);
        System.out.printf("%25s %25f %25s",arr2_1000.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem9 = LinearSearch(test_elem,arr3_1000);
        System.out.printf("%25s %25f %25s",arr3_1000.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem10 = LinearSearch(test_elem,arr1_3000);
        System.out.printf("%25s %25f %25s",arr1_3000.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem11 = LinearSearch(test_elem,arr2_3000);
        System.out.printf("%25s %25f %25s",arr2_3000.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem12 = LinearSearch(test_elem,arr3_3000);
        System.out.printf("%25s %25f %25s",arr3_3000.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem13 = LinearSearch(test_elem,arr1_10000);
        System.out.printf("%25s %25f %25s",arr1_10000.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem14 = LinearSearch(test_elem,arr2_10000);
        System.out.printf("%25s %25f %25s",arr2_10000.length,m_duration,m_comparison_number);
        System.out.println();

        int ind_elem15 = LinearSearch(test_elem,arr3_10000);
        System.out.printf("%25s %25f %25s",arr3_10000.length,m_duration,m_comparison_number);
        System.out.println();

        System.out.println("№2______________________________________________________________________________");
        quicksort(arr1_100);            //sort these arrays and use binary and linear search
        quicksort(arr1_500);            //to find the element
        quicksort(arr1_1000);
        quicksort(arr1_3000);
        quicksort(arr1_10000);

        System.out.println("Binary search in a sorted array");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%25s %25s %25s","Array size","Duration, seconds","Iteration number");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        int ind_elem16 = BinarySearch(test_elem,arr1_100);
        System.out.printf("%25s %25f %25s",arr1_100.length,m_duration,m_iteration_number);
        System.out.println();

        int ind_elem17 = BinarySearch(test_elem,arr1_500);
        System.out.printf("%25s %25f %25s",arr1_500.length,m_duration,m_iteration_number);
        System.out.println();

        int ind_elem18 = BinarySearch(test_elem,arr1_1000);
        System.out.printf("%25s %25f %25s",arr1_1000.length,m_duration,m_iteration_number);
        System.out.println();

        int ind_elem19 = BinarySearch(test_elem,arr1_3000);
        System.out.printf("%25s %25f %25s",arr1_3000.length,m_duration,m_iteration_number);
        System.out.println();

        int ind_elem20 = BinarySearch(test_elem,arr1_10000);
        System.out.printf("%25s %25f %25s",arr1_10000.length,m_duration,m_iteration_number);
        System.out.println();

        System.out.println("Linear search in a sorted array");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%25s %25s %25s","Array size","Duration, seconds","Iteration number");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

        int ind_elem21 = LinearSearch(test_elem,arr1_100);
        System.out.printf("%25s %25f %25s",arr1_100.length,m_duration,m_iteration_number);
        System.out.println();

        int ind_elem22 = LinearSearch(test_elem,arr1_500);
        System.out.printf("%25s %25f %25s",arr1_500.length,m_duration,m_iteration_number);
        System.out.println();

        int ind_elem23 = LinearSearch(test_elem,arr1_1000);
        System.out.printf("%25s %25f %25s",arr1_1000.length,m_duration,m_iteration_number);
        System.out.println();

        int ind_elem24 = LinearSearch(test_elem,arr1_3000);
        System.out.printf("%25s %25f %25s",arr1_3000.length,m_duration,m_iteration_number);
        System.out.println();

        int ind_elem25 = LinearSearch(test_elem,arr1_10000);
        System.out.printf("%25s %25f %25s",arr1_10000.length,m_duration,m_iteration_number);
        System.out.println();
    }

    }

