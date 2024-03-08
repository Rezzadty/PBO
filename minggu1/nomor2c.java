package minggu1; // nama folder 

class nomor2c { // nama file project
    public static void main(String[] args) {
        double tinggitabung = 10;
        double diametertabung = 5;
        double volumetabung = Math.PI * Math.pow(diametertabung, 2) * tinggitabung;

        System.out.println("Menghitung Volume Tabung\n");
        System.out.println("==============================");
        System.out.println("");
        System.out.println("Diameter tabung yang dikethau yaitu = " + diametertabung);
        System.out.println("Tinggi dari tabung tersebut adalah = " + tinggitabung);
        System.out.println("Jadi, Volume tabung adalah = " + volumetabung);
        System.out.println("\n==============================");
    }
}