package Test;

public class Sorting {

   public static int[] BubbleSort(int[] arr)
   {
       int i = arr.length - 1;
       int temp = 0;
       boolean flag = false;

       while (i > 0)
       {
           int k = 0;

           while (k < i)
           {
               if (arr[k] > arr[k + 1])
               {
                   temp = arr[k];
                   arr[k] = arr[k + 1];
                   arr[k+1] = temp;
                   flag = true;
               }
               k++;
           }
           if (flag == false)          //Iverson's condition
           {break;}
           i--;
       }
       return arr;
   }

    public static void main(String[] args) {

       int[] numb_arr = {1,2,3,4,5,6,7};

       int[] sorted_arr = BubbleSort(numb_arr);

       for (int value: sorted_arr)
       {
           System.out.print(value);
           System.out.print('\t');
       }
    }
}
