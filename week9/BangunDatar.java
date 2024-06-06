package week9; 

public class BangunDatar {
private int panjang; // Variabel panjang
private int lebar; // Variabel lebar
private int sisi; // Variabel sisi
private double jarijari; // Variabel Jari-jari
protected static final double pi = 3.14; // Konstanta pi yang bersifat protected dan final

    // Konstruktor dengan satu parameter sisi
    public BangunDatar(int sisi) 
    {
        this.sisi = sisi; 
    }

    // Konstruktor dengan dua parameter panjang dan lebar
    public BangunDatar(int panjang, int lebar) 
    {
        this.panjang = panjang; 
        this.lebar = lebar; 
    }

    // Metode untuk menghitung luas persegi
    public int luas(int sisi) 
    {
        return sisi * sisi; 
    }

    // Metode untuk menghitung luas persegi panjang
    public int luas(int panjang, int lebar) 
    {
        return panjang * lebar; 
    }

    // Metode untuk menghitung luas segitiga
    public double luas(double alas, double tinggi)
    {
        return (alas * tinggi) / 2; 
    }

    // Metode untuk menghitung luas lingkaran
    public double luas(double jarijari) 
    {
        return pi * jarijari * jarijari; 
    }

    // Metode untuk menghitung keliling persegi
    public int keliling(int sisi) 
    {
        return 4 * sisi; 
    }

    // Metode untuk menghitung keliling persegi panjang
    public int keliling(int panjang, int lebar) 
    {
        return 2 * (panjang + lebar); 
    }

    // Metode untuk menghitung keliling lingkaran
    public double keliling(double jarijari) 
    {
        return 2 * pi * jarijari; 
    }

    // Getter untuk variabel panjang
    public int getPanjang() 
    {
        return panjang; 
    }

    // Getter untuk variabel lebar
    public int getLebar() 
    {
        return lebar; 
    }

    // Getter untuk variabel jari-jari
    public double getJariJari() 
    {
        return jarijari; 
    }

    // Getter untuk variabel sisi
    public int getSisi() 
    {
        return sisi; 
    }
}
