package lab10_Hashing;

public class StringTable {

    private String[] m_arr;

    public StringTable(int size) { m_arr = new String[size]; }
    public int findAlphabetPosition(char let)
    {
        int start_position = 97;
        int temp = let;

        if (temp <= 122 & temp >= 97)
        { temp = temp - start_position; }
        else
        { temp = 0; }

        return temp;
    }

    public void put(String str)
    {
        int ind = hashCode(str);
        m_arr[ind] = str;
        System.out.println("The index of the string: " + str + " is " + ind);
    }

    public String get(String key) { return m_arr[hashCode(key)]; }

    private int hashCode(String key)
    {
        int hash_sum = 0;
        char[] arr_let = key.toCharArray();
        for (char let : arr_let)
        { hash_sum += findAlphabetPosition(let); }

        hash_sum += 26;
        hash_sum = (hash_sum & 0x7fffffff) % m_arr.length;    //so the hashcode will be less than the length
                                                              //of the array and won't be negative
        return hash_sum;
    }

    public static void main(String[] args)
    {
        final int capacity = 60;
        StringTable table_obj = new StringTable(capacity);
        String[] arr_str = {"cxzvxdvdvcxvd","dfgdfgthfhwewwsfsdf435","433sdfs","rteteefsdf6"};

        for (String str : arr_str)
        { table_obj.put(str); }

        for (int i = 0; i < arr_str.length; i++)
        { System.out.println(table_obj.get(arr_str[i])); }
    }
}