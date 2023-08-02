package Algorithms_The_Book;
//Union Find problem version 1.0. Might be improved

public class UnionFind {

    private int[] m_arr_id;

    public UnionFind(int size)
    {
        m_arr_id = new int[size];

        for (int i = 0; i < size; i++)
        { m_arr_id[i] = i; }
    }

    public boolean connected(int i, int j) { return m_arr_id[i] == m_arr_id[j]; }

    public void union(int i, int j)
    {
        int elem = 0;
        int i_elem = m_arr_id[i];
        int j_elem = m_arr_id[j];

        for (int k = 0; k < m_arr_id.length; k++)
        {
            if (m_arr_id[k] == i_elem) m_arr_id[k] = j_elem;
        }
    }
}
