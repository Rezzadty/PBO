package week1; // Mendefinisikan paket bernama week1

public class Aksimahasiswa {
    public static void main(String[] args) {
        // Membuat objek mhs1 dari kelas Mahasiswa dengan parameter nama dan nim
        Mahasiswa mhs1 = new Mahasiswa("Reza Aditya P", "A11.2022.14201", "08-11-2003");

        // Mengatur atribut usia mhs1
        mhs1.usia = 20;

        // Memanggil metode untuk menampilkan identitas mahasiswa
        mhs1.getIdentitas();

        // Memanggil metode untuk simulasi belajar mahasiswa
        mhs1.belajar();

        // Membuat objek mhs2 dari kelas Mahasiswa dengan parameter nama dan nim
        Mahasiswa mhs2 = new Mahasiswa("Reza Aditya Prabowo", "A11.2022.14201");
    }
}
