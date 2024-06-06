package week7;

public class AksiMahasiswa {
    public static void main(String[] args) {
        MahasiswaAktif mahasiswa1 = new MahasiswaAktif("A11.2022.14201", "Reza Aditya Prabowo", "08-11-2003", 4, 20);

        mahasiswa1.getIdentitas();
        System.out.println("Usia: " + mahasiswa1.usia);
        System.out.println("Tanggal Lahir: " + mahasiswa1.tanggal_lahir);
    }
}