package week9; 

// Mendefinisikan kelas BangunRuang yang merupakan subclass dari BangunDatar
public class BangunRuang extends BangunDatar {

    // Konstruktor dengan satu parameter sisi
    public BangunRuang(int sisi) 
    {
        super(sisi); 
    }

    // Konstruktor dengan dua parameter panjang dan lebar
    public BangunRuang(int panjang, int lebar) 
    {
        super(panjang, lebar); 
    }

    // Metode untuk menghitung volume kubus
    public double volumeKubus(int sisi) 
    {
        return sisi * sisi * sisi; 
    }

    // Metode untuk menghitung volume balok dengan parameter panjang, lebar, dan tinggi sebagai integer
    public double volumeBalok(int panjang, int lebar, int tinggi) 
    {
        return panjang * lebar * tinggi; 
    }

    // Metode untuk menghitung volume balok dengan parameter panjang, lebar, dan tinggi sebagai double
    public double volumeBalok(double panjang, double lebar, double tinggi) 
    {
        return panjang * lebar * tinggi; 
    }

    // Metode untuk menghitung volume bola
    public double volumeBola(double radius) 
    {
        return (4 / 3) * pi * Math.pow(radius, 3); 
    }
}
