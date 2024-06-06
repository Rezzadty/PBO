package week3;

public class Clock {
    public static void main(String[] args) {
        // Membuat objek jam dengan nilai awal jam 23 dan menit 59
        ClockDisplay jam = new ClockDisplay(23, 59);

        // Memanggil method timeTick() lima kali
        // Untuk menambah waktu sebanyak lima menit
        jam.timeTick();
        jam.timeTick();
        jam.timeTick();
        jam.timeTick();
        jam.timeTick();

        // Menampilkan waktu setelah ditambah lima menit
        System.out.println("Waktu = " + jam.getTime());
    }
}
