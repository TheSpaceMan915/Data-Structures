package lab2;
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

// version 1.

public class TestFiles {

    public static void FillFile(String file_name)
    {
        try {
            FileWriter file_stream = new FileWriter(file_name);
            //use BufferedWriter to write more efficiently
            BufferedWriter fin = new BufferedWriter(file_stream);
            final int min_value = -10, max_value = 10;

            for (int j = 0; j < 10; j++)
            {
                //generate a random value
                int rand = ThreadLocalRandom.current().nextInt(min_value,max_value + 1);

                //write that value in a file
                fin.write(String.valueOf(rand));
                fin.newLine();
            }
            fin.close();
        }
        catch (IOException exep)
        {
            exep.printStackTrace();
            System.exit(1);
        }
    }

    public static void ReadFile(String file_name)
    {
        ArrayList<Integer> arr_of_numbers = new ArrayList<>();
        int negative_counter = 0;

        try {
            FileReader out_stream = new FileReader(file_name);
            BufferedReader fout = new BufferedReader(out_stream);

            String temp = "";
            int value = 0;

            while (temp != null)
            {
                temp = fout.readLine();

                if (temp == null)
                {break;}

                value = Integer.parseInt(temp);
                if (value < 0)
                {
                    negative_counter++;
                    arr_of_numbers.add(value);
                }
            }
            fout.close();
        }
        catch (IOException exep)
        {
            exep.printStackTrace();
            System.exit(-1);
        }

        System.out.println("There are " + negative_counter + " negative numbers in " + arr_of_numbers);
    }


    public static void WriteCharacter(String file_name)
    {
        try
        {
            FileWriter file_stream = new FileWriter(file_name);
            BufferedWriter fin = new BufferedWriter(file_stream);
            Scanner keyboard = new Scanner(System.in);

            System.out.println("How many lines would you like to skip?");
            String str_input = keyboard.nextLine();
            int line_number = Integer.parseInt(str_input);
            System.out.println("At what position in the line would you like to print your string?");
            String str_input2 = keyboard.nextLine();
            int space_number = Integer.parseInt(str_input2);
            System.out.println("What will you print?");
            String input = keyboard.next();

            for (int i = 0; i < line_number;i++)
            {
                fin.newLine();
            }

            for (int k=0;k <space_number - 1;k++)
            {
                fin.write(" ");
            }

            fin.write(input);
            fin.close();
        }
        catch (IOException exep)
        {
            exep.printStackTrace();
            System.exit(-1);
        }
    }

    public static void ReadFile2(String file_name)
    {
        try
        {
            FileReader out_stream = new FileReader(file_name);
            BufferedReader fout = new BufferedReader(out_stream);
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Which line would you like to read?");
            int numb = keyboard.nextInt();      //read an integer from keyboard
            //System.out.println(numb);

            String temp_line = "";
            for (int j = 0;j<numb;j++)
            {
                temp_line = fout.readLine();        //read first numb-1 strings
            }
            temp_line = fout.readLine();         //read and print the string we need

            if (temp_line == null)
            {System.out.println("There is nothing in the line number " + numb);}
            else
            {System.out.println(temp_line);}
        }
        catch (IOException exep)
        {
            exep.printStackTrace();
            System.exit(1);
        }
    }

    //#4________________________________________________
    public class Sub_str
    {
        public int m_line_numb = 0;
        public int m_ind = 0;

        public Sub_str(int line_numb,int ind)
        {
            m_line_numb = line_numb;
            m_ind = ind;
        }
    }

    public ArrayList<Sub_str> FindSubstring(String substr,String path)
    {
        ArrayList<Sub_str> arr = new ArrayList<Sub_str>();
        try
        {
            FileReader out_stream = new FileReader(path);
            BufferedReader fout = new BufferedReader(out_stream);
            String temp_line = "";
            int line_counter = 0;
            int substr_ind = 0;

            while ((temp_line = fout.readLine()) != null)
            {
                line_counter++;
                substr_ind = temp_line.indexOf(substr);
                if (substr_ind != -1)
                {
                    arr.add(new Sub_str(line_counter,substr_ind));
                }
            }
        }
        catch (IOException exep)
        {
            exep.printStackTrace();
            System.exit(1);
        }
        return arr;
    }


//    public static int findIndex(ArrayList<String> arr_of_words, String word) {
//        for(int i  = 0; i < arr_of_words.size(); i++) {
//            if(arr_of_words.get(i) == word) return i;
//        }
//        return -1;
//    }
//
//    public static void FindUniqueWords(String file_name)
//    {
//        ArrayList<String> arr_of_words = new ArrayList<String>();
//        ArrayList<Integer> repeats = new ArrayList<Integer>();
//        try
//        {
//            FileReader out_stream = new FileReader(file_name);
//            BufferedReader fout = new BufferedReader(out_stream);
//            String temp = "";
//
//            while ((temp = fout.readLine()) != null)
//            {
//                if(!arr_of_words.contains(temp)) {
//                    arr_of_words.add(temp);
//
//                    repeats.add(1);
//                }
//                else {
//                    int index = findIndex(arr_of_words, temp);
//                    repeats.set(index, repeats.get(index) + 1);
//                }
//            }
//        }
//        catch (IOException exep)
//        {
//            System.out.println("There's been a problem");
//            exep.printStackTrace();
//        }
//        System.out.println(set_of_words);
//        //return set_of_words.size();
//    }

    //#5________________________________________________
    public static int LookForUniqueWords(String file_name)
    {
        Set<String> set_of_words = new HashSet<String>(12,0.75f);
        try
        {
            FileReader out_stream = new FileReader(file_name);
            BufferedReader fout = new BufferedReader(out_stream);
            String temp_line= "";

            while ((temp_line = fout.readLine()) != null)
            {
                temp_line = temp_line.replaceAll("\\p{Punct}","");  //remove all punctuation
                String[] sentence = temp_line.split(" ");       //split the string into separate words

                for (var x: sentence)
                {set_of_words.add(x);}
            }
        }
        catch (IOException exep)
        {
            System.out.println("There's been a problem");
            exep.printStackTrace();
        }

        return set_of_words.size();
    }

    public class Word {
        public String m_word;
        public int m_counter;

        Word(String word)
        {m_word = word;
        m_counter = 0;
        }
    }

    public void CountWords(String f_name)
    {
        Set<String> set_of_unique_words;                         //create the set to compare the unique words
        ArrayList<String> all_words = new ArrayList<String>();  //here we store all words
        ArrayList<Word> words_list = new ArrayList<Word>();     //the set of words + their counters
        try
        {
            FileReader out_stream = new FileReader(f_name);
            BufferedReader fout = new BufferedReader(out_stream);
            String line = "";
            String[] temp_words;

            while ((line = fout.readLine()) != null)
            {
                line = line.replaceAll("\\p{Punct}","");
                temp_words = line.split(" ");

                for (var l : temp_words)
                {all_words.add(l);}         //create the list with all words from the file
            }

            set_of_unique_words = new HashSet<String>(all_words);   //create the set from the list

            for (String word_from_set : set_of_unique_words)
            {
                words_list.add(new Word(word_from_set));    //create a new ArrayList with Words ( using the class)
            }

            for (int i = 0; i < words_list.size();i++)      //compare one element from words_list
            {                                               //with all elements in all_words list
                for (String temp : all_words)
                {
                    if (words_list.get(i).m_word.equals(temp))  // use equals as == for objects
                    {words_list.get(i).m_counter++;}
                }
            }

            for (Word temp: words_list)
            {
                System.out.println("The word: "+ temp.m_word + " occurs " + temp.m_counter + " times");
            }
        }
        catch (IOException exep)
        {
            System.out.println("Something went wrong");
            exep.printStackTrace();
        }
    }

    public static void DeletePunctuation(String out_file_name,String in_file_name)
    {
        String marks_arr = "!?.,:;\"";

        try
        {
            FileReader out_stream = new FileReader(out_file_name);
            BufferedReader fout = new BufferedReader(out_stream);
            FileWriter in_stream = new FileWriter(in_file_name);
            BufferedWriter fin = new BufferedWriter(in_stream);
            String temp_line = "";
            String temp_line2 = "";
            char arr[];

            while ((temp_line = fout.readLine()) != null)
            {
                arr = temp_line.toCharArray();
                for (int i = 0;i<marks_arr.length();i++)
                {
                    for (int k = 0;k<temp_line.length();k++)
                    {
                        if (marks_arr.charAt(i) == arr[k])
                        {
                            arr[k] = Character.MIN_VALUE;   //assign an empty character
                        }
                    }
                }
                temp_line2 = arr.toString();
                fin.write(temp_line2);
                fin.newLine();
            }
            fout.close();
            fin.close();
        }
        catch (IOException exep)
        {
            System.out.println("There's been a problem");
            exep.printStackTrace();
        }


    }

    public static void main(String[] args)
    {
        File path = new File("C:\\Users\\nikit\\IdeaProjects\\Data Structures\\src\\lab2\\OutputData.txt");
        File path2 = new File("C:\\Users\\nikit\\IdeaProjects\\Data Structures\\src\\lab2\\Task2.txt");
        //FillFile(path.getPath());
        //ReadFile(path.getPath());

       // WriteCharacter(path2.getPath());
       // ReadFile2("C:\\Users\\nikit\\IdeaProjects\\Data Structures\\src\\lab2\\Task3.txt");

        TestFiles obj = new TestFiles();
        String s = "hello";
        File path3 = new File("C:\\Users\\nikit\\IdeaProjects\\Data Structures\\src\\lab2\\Task4.txt");
        ArrayList<Sub_str> arr_list = obj.FindSubstring(s,path3.getPath());

        for (int i = 0;i < arr_list.size();i++)
        {
            System.out.println("The substring is found on the line " + arr_list.get(i).m_line_numb +" starting with index " + arr_list.get(i).m_ind);
        }

        File path4 = new File("C:\\Users\\nikit\\IdeaProjects\\Data Structures\\src\\lab2\\Task5.txt");
        File path5 = new File("C:\\Users\\nikit\\IdeaProjects\\Data Structures\\src\\lab2\\WithoutPunctuation.txt");
        int unique_words = LookForUniqueWords(path4.getPath());
        System.out.println("There are " + unique_words + " unique words in the file");

        obj.CountWords(path4.getPath());

        DeletePunctuation(path4.getPath(), path5.getPath());
    }

    
}
