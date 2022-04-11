package lab1_Sets;
//В первом задании второй лабораторной читать файлы побитово

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DriveTest {

    public static void main(String[] args) {
//the 1st task
        Set <String> str_set = new HashSet<String>();   //create a set
                                                        //Set is an interface but
        str_set.add("Apple");                           //you can make a Set link in
        str_set.add("Banana");                          //order to use polymorphism
        str_set.add("Tomato");

        System.out.println("My set is " + str_set);
        TestSet.PrintSet(str_set);

//the 2nd task
        String str1 = "He likes reading books";
        String str2 = "She likes reading comics";

        String[] arr_str1 = str1.split(" ");      //split these strings in words
        String[] arr_str2 = str2.split(" ");

        Set <String> s_set1  = new HashSet <String>();
        Set <String> s_set2 = new HashSet <String>();

        for (String temp : arr_str1)        //add the arrays in the sets
        {
            s_set1.add(temp);
        }

        for (String temp : arr_str2)
        {
            s_set2.add(temp);
        }

        //compare the two sets
        ArrayList<String> arr_same_words = TestSet.CompareStrings(s_set1,s_set2);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println("The same words are " + arr_same_words);
        System.out.print("\n");

//the 3rd task
        Set <String> s_set = new <String> HashSet(5);

        s_set.add("ы");
        s_set.add("8");
        s_set.add("q");
        s_set.add("u");
        s_set.add("м");

        System.out.println("Your set is " + s_set);
        TestSet.SortSet(s_set);
    }
}
