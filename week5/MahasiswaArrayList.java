package week5; // Mendefinisikan paket bernama week5

import week1.Mahasiswa; // Mengimpor kelas Mahasiswa dari paket week1

public class MahasiswaArrayList {
    public static void main(String[] args) {
        // Membuat instance dari kelas Mahasiswa dengan nama, NIM, dan nilai null
        Mahasiswa mhs = new Mahasiswa("Reza Aditya", "14201", null);
        
        // Menambahkan nilai ke daftar nilai mahasiswa
        mhs.insertNilai(86.0);
        
        // Baris ini dikomentari, jadi method getIdentitas tidak akan dipanggil
        // mhs.getIdentitas();

        // Menambahkan mata kuliah ke daftar mata kuliah mahasiswa
        mhs.insertMatkul("PBO", "A11.4404", 4); // Menambahkan mata kuliah PBO dengan kode dan jumlah SKS
        mhs.insertMatkul("Alpro", "A11.4416", 2); // Menambahkan mata kuliah Alpro dengan kode dan jumlah SKS
        mhs.insertMatkul("Kalkulus", "A11.4406", 3); // Menambahkan mata kuliah Kalkulus dengan kode dan jumlah SKS
        
        // Menampilkan daftar mata kuliah yang telah ditambahkan
        mhs.showMatkul();
    }
}
