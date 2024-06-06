package week2;

public class Krs {
    String[] matakuliah = new String[5];
    int[] sks = new int[5];
    int totalsks = 0;

    public void setMataKuliah(String matkul, int index)
    {
        matakuliah[index] = matkul;
    }

    public void setSks(int kredit, int index)
    {
        sks[index] = kredit;
    }

    public int sumOfSks()
    {
        for(int i = 0;i < sks.length; i++)
        {
            totalsks = totalsks + sks[i];
        }
        return totalsks;
    }
}