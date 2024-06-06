package week5; // Mendefinisikan paket bernama week5

public class Matakuliah {
    
    public String matkul; // Deklarasi variabel publik untuk menyimpan nama mata kuliah
    public String kelompok; // Deklarasi variabel publik untuk menyimpan kelompok mata kuliah
    public int sks; // Deklarasi variabel publik untuk menyimpan jumlah SKS mata kuliah

    // Konstruktor kelas Matakuliah yang menginisialisasi variabel matkul, kelompok, dan sks
    public Matakuliah (String matkul, String kelompok, int sks) {
        this.matkul = matkul; // Inisialisasi variabel matkul dengan parameter matkul
        this.kelompok = kelompok; // Inisialisasi variabel kelompok dengan parameter kelompok
        this.sks = sks; // Inisialisasi variabel sks dengan parameter sks
    }

    // Metode untuk mendapatkan nama mata kuliah
    public String getMatkul() {
        return matkul; // Mengembalikan nilai variabel matkul
    }

    // Metode untuk mendapatkan kelompok mata kuliah
    public String getKelompok() {
        return kelompok; // Mengembalikan nilai variabel kelompok
    }

    // Metode untuk mendapatkan jumlah SKS mata kuliah
    public int getSks() {
        return sks; // Mengembalikan nilai variabel sks
    }

}
