package Algorithms_The_Book;

public class Sorting_Algorithms {

    // Templates for sort algorithms
    private static boolean less(Comparable value1, Comparable value2)
    { return value1.compareTo(value2) < 0; }

    private static void exch(Comparable arr[],int ind1,int ind2)
    {
        Comparable temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    public static void PrintArray(Comparable arr[])
    {
        for (var value : arr)
        {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    // The algorithms from uni
   public static void BubbleSort(Comparable[] arr)
   {
       int i = arr.length - 1;
       boolean flag = false;

       while (i > 0)
       {
           int k = 0;

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
   }

   public static int[] CocktailSort(int[] arr)
   {
       int end = arr.length - 1;
       int start = 0;
       int temp = 0;
       boolean flag = true;

       while (flag)
       {
           flag = false;
           for (int k = start; k < end;k++)
           {
               if (arr[k] > arr[k+1])
               {
                   temp = arr[k];
                   arr[k] = arr[k+1];
                   arr[k+1] = arr[k];
                   flag = true;
               }
           }

           if (flag == false)
           {break;}
           end--;

           for (int i = end; i > start;i--)
           {
               if (arr[i] < arr[i-1])
               {
                   temp = arr[i-1];
                   arr[i - 1] = arr[i];
                   arr[i] = temp;
               }
           }
           start++;
       }
       return arr;
   }

    public void shellSort(Comparable[] arr) {
        ;
    }

   //It is not working properly
   /*public static void QuickSort(int[] arr) {QuickSortHelper(arr,0,arr.length - 1);}

    public static void QuickSortHelper(int[] arr, int L, int R)
    {
        if (L >= R)
            {return;}

        int m = (L+R) / 2;
        int x = arr[m];
        int i = L;
        int j = R;
        int temp = 0;

        while (i < j)
        {
            while (arr[i] < x)
                {i++;}

            while (arr[j] > x)
                {j--;}

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        if (j > L)
            {QuickSortHelper(arr,L,j);}

        if (i < R)
            {QuickSortHelper(arr,i,R);}
    }*/

   //Other algorithms

    //Another version of Quicksort. In this version the median is the last element of an array
    public static void quicksort(Comparable[] arr) {qs(arr, 0, arr.length - 1);}

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

    public static void SelectionSort(Comparable[] arr)
    {
        int min_ind = 0;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++)
        {
            min_ind = i;
            for (int j = i + 1; j < arr.length;j++)
            {
                if (less(arr[j],arr[min_ind]))
                {min_ind = j;}
            }
            exch(arr,i,min_ind);
        }
    }

    public static void InsertionSort(Comparable[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            for ( int j = i; j > 0; j--)
            {
                if (less(arr[j],arr[j-1]))
                {
                    exch(arr,j,j-1);
                }
            }
        }
    }

    //HeapSort_______________________________________
    private static boolean ElemLess(Comparable[] arr,int j, int k)
    {
        int k1 = j-1;
        int k2 = k-1;

        return arr[k1].compareTo(arr[k2]) < 0;
        //decrement because an array starts not from 1 index (like a heap) but from 0 index
    }

    private static void ElemExch(Comparable arr[],int i1,int i2)
    {
        int k1 = i1-1;
        int k2 = i2-1;

        Comparable temp = arr[k1];
        arr[k1] = arr[k2];
        arr[k2] = temp;
    }

    public static void sink(Comparable arr[],int k,int arr_size)
    {
        while (2*k <= arr_size)
        {
            int j = 2*k;
            if (j < arr_size && (ElemLess(arr,j,j+1))) j++;     //choose the biggest child node
            if (!ElemLess(arr,k,j)) break;                         //if the child more than its parent,
                                                                    //move on to the next parent
            ElemExch(arr,k,j);
            k = j;
        }
    }
    public static void HeapSort(Comparable[] arr)
    {
        int n = arr.length;
        for (int i = n/2; i >= 1; i--)
        { sink(arr,i,n); }

        int k = n;
        while (k > 1)
        {
            ElemExch(arr,1,k--);
            sink(arr,1,k);
        }
    }
    //_______________________________________




    public static void main(String[] args) {

       int[] numb_arr = {9,8,10,4,5,6,7};
       Comparable[] numb_arr2 = {12,11,20,9,8,6,7};


       long start_time1 = System.nanoTime();
        HeapSort(numb_arr2);
        long end_time1 = System.nanoTime();
        //System.out.println(end_time1 - start_time1);


        //int[] sorted_arr = BubbleSort(numb_arr);
       //int[] sorted_arr2 = CocktailSort(numb_arr);

        PrintArray(numb_arr2);
    }
}
