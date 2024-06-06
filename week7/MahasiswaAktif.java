package week7;

import week1.Mahasiswa;

public class MahasiswaAktif extends Mahasiswa {

    public int usia;
    public int semester;
    public String tanggal_lahir;

    public MahasiswaAktif(String nim, String nama, String tanggal_lahir, int semester, int usia) {
        super(nim, nama, tanggal_lahir);
        this.usia = usia;
        this.semester = semester;
    }

}
