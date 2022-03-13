package lab1;
import java.util.*;
import java.lang.*;

public class TestSet {

    public static void PrintSet(Set obj)
    {
        int count = 0;
        Iterator value = obj.iterator();     //create iterator

        while(value.hasNext())
        {
            System.out.println(value.next());
            count++;
        }
        System.out.println("The number of members in the set is " + count);
        System.out.print("\n");
    }

    public static ArrayList<String> CompareStrings(Set<String> obj1, Set<String> obj2)
    {
        ArrayList <String> similar_words = new ArrayList <String>();

        for (String temp : obj1)
        {
            if (obj2.contains(temp))
            {
                similar_words.add(temp);
            }
        }

        return similar_words;
    }

    public static void SortSet(Set <String> obj)    //use regex (regular expressions)
    {                                               //to differ letters
        Set<String> s_rus = new HashSet<String>();
        Set<String> s_lat = new HashSet<String>();
        Set<String> s_numbers = new HashSet<String>();

        for (String temp : obj)     //sort each letter
        {
            boolean check_rus = (temp != null) && (!temp.equals("") &&
                    (temp.matches("^[а-яА-я]*$")));

            boolean check_lat = (temp != null) && (!temp.equals("") &&
                    (temp.matches("^[a-zA-Z]*$")));

            boolean check_numbers = (temp != null) && (!temp.equals("") &&
                    (temp.matches("^[0-9]*$")));

            if (check_rus)
                s_rus.add(temp);

            else if (check_lat)
                s_lat.add(temp);

            else
                s_numbers.add(temp);
        }

        System.out.println(s_rus);
        System.out.println(s_lat);
        System.out.println(s_numbers);
    }

}
