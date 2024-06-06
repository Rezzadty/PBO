package week3;

public class NumberDisplay 
{
    private int limit;
    private int value;

    // Constructor
    public NumberDisplay (int rollOverList) 
    {
        limit = rollOverList;
        value = 0;    
    }
    
    public int getValue()
    {
        return value;
    }

    public void setValue(int nilai)
    {
        if((nilai >= 0) && (nilai < limit))
        {
            value = nilai;
        }
    }

    public String getDisplayValue()
    {
        if (value<10)
        {
            return "0" + value; // Concatenate atau Penggabungan
        }
        else
        {
            return "" + value;
        }
    }

    public void increment ()
    {
        value = (value + 1) % limit;
    }
}
