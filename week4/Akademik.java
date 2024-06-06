package week4; // Mendefinisikan paket bernama week4

import week1.Mahasiswa; // Mengimpor kelas Mahasiswa dari paket week1
import java.util.*; // Mengimpor semua kelas dari paket java.util

public class Akademik {
    public static void main (String[] args){
        int n; // Deklarasi variabel untuk menyimpan jumlah data
        System.out.println("=======================");
        System.out.println("Masukkan jumlah data : ");

        // Buat objek dari class Scanner untuk menginput data
        Scanner inp = new Scanner(System.in);
        n = inp.nextInt(); // Membaca jumlah data dari input pengguna

        // Membuat variabel array dengan tipe Mahasiswa
        Mahasiswa[] mhs = new Mahasiswa[n];

        String nim;
        String nama;
        Double ipk;

        // Mengisi array dengan data Mahasiswa
        for(int i = 0; i < n; i++){ //inp = input
            System.out.println("Data ke-"+(i+1));
            System.out.print("Masukkan NIM : ");
            nim = inp.next(); // Membaca NIM dari input pengguna
            System.out.print("Masukkan IPK : ");
            ipk = inp.nextDouble(); // Membaca IPK dari input pengguna
            System.out.print("Masukkan Nama : ");
            nama = inp.next(); // Membaca Nama dari input pengguna
            
            mhs[i] = new Mahasiswa(nama, nim, ipk, null); // Membuat objek Mahasiswa dan mengisi array
        }

        // Menampilkan identitas setiap Mahasiswa
        for(int i = 0; i < mhs.length; i++){
            mhs[i].getIdentitas();
        }

        inp.close(); // Menutup scanner untuk membebaskan sumber daya
    }    
}
