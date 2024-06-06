package week1; // Mendefinisikan paket bernama week1

import java.util.ArrayList; // Mengimpor kelas ArrayList
import java.util.Iterator; // Mengimpor kelas Iterator
import week5.Matakuliah; // Mengimpor kelas Matakuliah dari paket week5

public class Mahasiswa {
    public String nim, nama; // Deklarasi variabel publik untuk NIM dan nama
    public int usia; // Deklarasi variabel publik untuk usia
    public Double ipk; // Deklarasi variabel publik untuk IPK
    private String tanggal_lahir; // Deklarasi variabel privat untuk tanggal lahir
    private ArrayList<Double> nilai = new ArrayList<Double>(); // Membuat ArrayList untuk nilai
    private ArrayList<Matakuliah> mk = new ArrayList<Matakuliah>(); // Membuat ArrayList untuk mata kuliah

    // Konstruktor untuk menginisialisasi nama, nim, ipk, dan tanggal lahir
    public Mahasiswa(String nama, String nim, Double ipk, String tanggal_lahir) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
        this.tanggal_lahir = tanggal_lahir;
    }

    // Konstruktor untuk menginisialisasi nama, nim, dan tanggal lahir
    public Mahasiswa(String nama, String nim, String tanggal_lahir) {
        this.nama = nama;
        this.nim = nim;
        this.tanggal_lahir = tanggal_lahir;
    }

    // Konstruktor untuk menginisialisasi nama dan nim
    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Metode untuk menambahkan nilai ke ArrayList
    public void insertNilai(double n1) {
        nilai.add(n1);
    }

    // Metode untuk menambahkan mata kuliah ke ArrayList
    public void insertMatkul(String matkul, String kelompok, int sks) {
        mk.add(new Matakuliah(matkul, kelompok, sks));
    }

    // Metode untuk simulasi belajar mahasiswa
    public void belajar() {
        System.out.println(nama + " belajar");
    }

    // Metode untuk simulasi main game mahasiswa
    public void mainGame() {
        System.out.println(nama + " main game");
    }

    // Metode untuk menampilkan identitas mahasiswa
    public void getIdentitas() {
        System.out.println("\nDISPLAY DATA MAHASISWA");
        System.out.println("Nama Mahasiswa : " + nama);
        System.out.println("NIM Mahasiswa : " + nim);
        System.out.println("Tanggal Lahir : " + tanggal_lahir);
        System.out.println("Usia : " + usia);
        System.out.println("IPK : " + ipk);
        System.out.println("Nilai : " + nilai);
    }

    // Metode untuk menampilkan semua nilai yang dimiliki mahasiswa
    public void getNilai() {
        Iterator<Double> it = nilai.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // Metode untuk menampilkan daftar mata kuliah
    public void showMatkul() {
        System.out.println("\n================");
        System.out.println("Daftar MATKUL :");
        System.out.println("================\n");
        
        // Menggunakan for-each untuk menampilkan mata kuliah
        for (Matakuliah matkul : mk) {
            System.out.println(matkul.getMatkul() + " - " + matkul.getKelompok() + " - " + matkul.getSks());
        }
    }
}
