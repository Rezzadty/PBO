package week2;

public class Inputkrs {
    public static void main(String[] args) {
        Krs krs1 = new Krs();

        /* krs1.matakuliah[0] = "Pemrograman Web";
        krs1.matakuliah[1] = "PBO";
        krs1.matakuliah[2] = "Dasar Pemrograman";

        krs1.sks[0] = 3;
        krs1.sks[1] = 4;
        krs1.sks[2] = 2;  */

        krs1.setMataKuliah ("Pemrograman Web", 0);
        krs1.setMataKuliah ("PBO", 1);
        krs1.setMataKuliah ("Dasar Pemrograman", 2);

        krs1.setSks (3, 0);
        krs1.setSks (4, 1);
        krs1.setSks (2, 2);

        krs1.sumOfSks();

        System.out.println("\nNama mata kuliah = " + krs1.matakuliah[0] + " SKS : " + krs1.sks[0]);
        System.out.println("Nama mata kuliah = " + krs1.matakuliah[1] + " SKS : " + krs1.sks[1]);
        System.out.println("Nama mata kuliah = " + krs1.matakuliah[2] + " SKS : " + krs1.sks[2]);
        System.out.println("Total SKS = " + krs1.totalsks);
    }
}
