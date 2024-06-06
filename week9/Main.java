package week9; 
import java.util.Scanner; 

// Nama : Reza Aditya Prabowo
// NIM  : A11.2022.14201
// Mata Kuliah : PBO

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat instance Scanner untuk membaca input dari pengguna
        BangunDatar bangunDatar = null; // Mendeklarasikan variabel bangunDatar dengan tipe BangunDatar, diinisialisasi dengan null
        BangunRuang bangunRuang = null; // Mendeklarasikan variabel bangunRuang dengan tipe BangunRuang, diinisialisasi dengan null

        // Menampilkan menu pilihan operasi kepada pengguna
        System.out.println("Pilih operasi:");
        System.out.println("1. Luas Persegi");
        System.out.println("2. Luas Persegi Panjang");
        System.out.println("3. Luas Segitiga");
        System.out.println("4. Luas Lingkaran");
        System.out.println("5. Volume Kubus");
        System.out.println("6. Volume Balok");
        System.out.println("7. Volume Bola");
        System.out.print("Masukkan Pilihan : "); // Meminta pengguna untuk memilih salah satu opsi

        int pilihan = scanner.nextInt(); // Membaca input pengguna dan menyimpannya dalam variabel pilihan

        // Menggunakan switch case untuk menangani berbagai pilihan pengguna
        switch (pilihan) {
            case 1:
                // Menghitung dan menampilkan luas serta keliling persegi
                System.out.print("Masukkan sisi: ");
                int sisi = scanner.nextInt(); 
                bangunDatar = new BangunDatar(sisi); 
                System.out.println("Luas Persegi: " + bangunDatar.luas(sisi)); 
                System.out.println("Keliling Persegi: " + bangunDatar.keliling(sisi)); 
                break;
            case 2:
                // Menghitung dan menampilkan luas serta keliling persegi panjang
                System.out.print("Masukkan panjang: ");
                int panjang = scanner.nextInt(); 
                System.out.print("Masukkan lebar: ");
                int lebar = scanner.nextInt(); 
                bangunDatar = new BangunDatar(panjang, lebar); 
                System.out.println("Luas Persegi Panjang: " + bangunDatar.luas(panjang, lebar)); 
                System.out.println("Keliling Persegi Panjang: " + bangunDatar.keliling(panjang, lebar)); 
                break;
            case 3:
                // Menghitung dan menampilkan luas segitiga
                System.out.print("Masukkan alas: ");
                double alas = scanner.nextDouble(); 
                System.out.print("Masukkan tinggi: ");
                double tinggi = scanner.nextDouble(); 
                bangunDatar = new BangunDatar(0); 
                System.out.println("Luas Segitiga: " + bangunDatar.luas(alas, tinggi)); 
                break;
            case 4:
                // Menghitung dan menampilkan luas serta keliling lingkaran
                System.out.print("Masukkan jari-jari: ");
                double jariJari = scanner.nextDouble(); 
                bangunDatar = new BangunDatar(0); 
                System.out.println("Luas Lingkaran: " + bangunDatar.luas(jariJari)); 
                System.out.println("Keliling Lingkaran: " + bangunDatar.keliling(jariJari)); 
                break;
            case 5:
                // Menghitung dan menampilkan volume kubus
                System.out.print("Masukkan sisi: ");
                sisi = scanner.nextInt(); 
                bangunRuang = new BangunRuang(sisi); 
                System.out.println("Volume Kubus: " + bangunRuang.volumeKubus(sisi)); 
                break;
            case 6:
                // Menghitung dan menampilkan volume balok
                System.out.print("Masukkan panjang: ");
                panjang = scanner.nextInt(); 
                System.out.print("Masukkan lebar: ");
                lebar = scanner.nextInt(); 
                System.out.print("Masukkan tinggi: ");
                tinggi = scanner.nextInt(); 
                bangunRuang = new BangunRuang(panjang, lebar); 
                System.out.println("Volume Balok: " + bangunRuang.volumeBalok(panjang, lebar, tinggi)); 
                break;
            case 7:
                // Menghitung dan menampilkan volume bola
                System.out.print("Masukkan jari-jari: ");
                jariJari = scanner.nextDouble(); 
                bangunRuang = new BangunRuang(0); 
                System.out.println("Volume Bola: " + bangunRuang.volumeBola(jariJari)); 
                break;
            default:
                // Menampilkan pesan jika pilihan tidak valid
                System.out.println("Pilihan tidak valid.");
                break;
        }
        System.out.println("");
        System.out.println("Terimakasih Telah Menggunakan Program\n");
        System.out.println("=^ W ^= \n");
        scanner.close(); 
    }
}
