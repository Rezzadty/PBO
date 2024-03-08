package minggu1; // nama folder 

class nomor2c { // nama file project
    public static void main(String[] args) {
        double tinggitabung = 10; //Double untuk tinggi dari tabung
        double diametertabung = 5; //Double untuk diamaeter tabung
        double volumetabung = Math.PI * Math.pow(diametertabung, 2) * tinggitabung; //Double untuk menghitung Volume dari Tabung

        System.out.println("Menghitung Volume Tabung\n");
        System.out.println("==============================");
        System.out.println("");
        System.out.println("Diameter tabung yang dikethau yaitu = " + diametertabung);
        System.out.println("Tinggi dari tabung tersebut adalah = " + tinggitabung);
        System.out.println("Jadi, Volume tabung adalah = " + volumetabung);
        System.out.println("\n==============================");
    }
}
