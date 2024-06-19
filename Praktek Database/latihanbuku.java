package latihan_PBO;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class latihanbuku {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/java_db";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Masukkan Data");
            System.out.println("2. Update Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Tampilkan Data");
            System.out.println("5. Keluar Dari Program");
            System.out.print("Masukkan Opsi Pilihan: ");
            
            int choice = getInputInt(scanner);
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1: insert(scanner); break;
                case 2: update(scanner); break;
                case 3: delete(scanner); break;
                case 4: show(); break;
                case 5: System.out.println("Program Ditutup, Terimakasih Sudah Menggunakan Program ^w^ "); scanner.close(); return;
                default: System.out.println("Input Yang Dimasukkan Tidak Valid. Tolong Masukkan Input Yang Benar.");
            }
        }
    }
    
    public static int getInputInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input Yang Dimasukkan Tidak Valid. Tolong Masukkan Input Yang Benar.");
                scanner.next(); // Clear invalid input
            }
        }
    }
    
    public static void connect() throws Exception {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void close() throws Exception {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    }
    
    public static void insert(Scanner scanner) {
        try {
            connect();
            System.out.println("");
            System.out.print("Masukkan ID Buku : "); //input ID Buku
            int id = getInputInt(scanner);
            scanner.nextLine(); // Consume newline 
            System.out.print("Judul Buku : "); //input judul buku
            String judul_buku = scanner.nextLine();
            System.out.print("Tahun Buku : "); //input dari tahun pembuatan buku
            int tahun = getInputInt(scanner);
            System.out.print("Stok Buku : "); //input stok dari buku
            int stok = getInputInt(scanner);
            scanner.nextLine(); // Consume newline
            System.out.print("Penulis Buku : "); //input penulsi dari buku
            String penulis = scanner.nextLine();
            System.out.println("");
            
            // SQL Command untuk memasukkan data ke dalam database ke Tabel buku
            String sql = "INSERT INTO buku (id, judul_buku, tahun, stok, penulis) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, judul_buku);
            ps.setInt(3, tahun);
            ps.setInt(4, stok);
            ps.setString(5, penulis);
            ps.execute();
            
            // SQL Command untuk memasukkan data ke dalam database ke Tabel Penulis
            sql = "INSERT INTO penulis (id, nama_penulis) VALUES (?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, penulis);
            ps.execute();
            
            System.out.println("Data telah sukses dimasukkan ke database.");
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
    
    public static void update(Scanner scanner) {
        try {
            connect();
            System.out.print("Masukkan ID Buku yang ingin diupdate: ");
            int id = getInputInt(scanner);
            scanner.nextLine(); // Consume newline
            
            String sql = "SELECT * FROM buku WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                System.out.println("");
                System.out.println("Data saat ini :");
                System.out.println("ID Buku : " + rs.getInt("id"));
                System.out.println("Judul Buku : " + rs.getString("judul_buku"));
                System.out.println("Tahun : " + rs.getInt("tahun"));
                System.out.println("Stok : " + rs.getInt("stok"));
                System.out.println("Penulis : " + rs.getString("penulis"));
                System.out.println("");
                
                System.out.print("Masukkan Judul Buku baru (kosongkan jika tidak ingin mengubah): ");
                String judul_buku = scanner.nextLine();
                if (judul_buku.isEmpty()) judul_buku = rs.getString("judul_buku");
                
                System.out.print("Masukkan Tahun baru (kosongkan jika tidak ingin mengubah): ");
                String tahunStr = scanner.nextLine();
                int tahun = tahunStr.isEmpty() ? rs.getInt("tahun") : Integer.parseInt(tahunStr);
                
                System.out.print("Masukkan Stok baru (kosongkan jika tidak ingin mengubah): ");
                String stokStr = scanner.nextLine();
                int stok = stokStr.isEmpty() ? rs.getInt("stok") : Integer.parseInt(stokStr);
                
                System.out.print("Masukkan Penulis baru (kosongkan jika tidak ingin mengubah): ");
                String penulisStr = scanner.nextLine();
                String penulis = penulisStr.isEmpty() ? rs.getString("penulis") : penulisStr;
                
                // SQL Command memasukkan update data ke database pada Tabel buku
                sql = "UPDATE buku SET judul_buku = ?, tahun = ?, stok = ?, penulis = ? WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, judul_buku);
                ps.setInt(2, tahun);
                ps.setInt(3, stok);
                ps.setString(4, penulis);
                ps.setInt(5, id);
                ps.execute();
                
                // SQL Command memasukkan update data ke database pada Tabel penulis
                sql = "UPDATE penulis SET nama_penulis = ? WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, penulis);
                ps.setInt(2, id);
                ps.execute();
                
                System.out.println("Data berhasil di update.");
            } else {
                System.out.println("Id Buku tidak sapat ditemukan : " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
    
    public static void delete(Scanner scanner) {
        try {
            connect();
            System.out.print("Masukkan ID Buku yang ingin dihapus : ");
            int id = getInputInt(scanner);
            scanner.nextLine(); // Consume newline
            
            //SQL Command Dari Hapus isi tabel database
            String sql = "DELETE FROM buku WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                sql = "DELETE FROM penulis WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                
                System.out.println("Data Berhasil Di Hapus.");
            } else {
                System.out.println("Id Buku Tidak Dapat Ditemukan : " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
    
    public static void show() {
        try {
            connect();
            String sql = "SELECT b.id, b.judul_buku, b.tahun, b.stok, p.nama_penulis " +
                         "FROM buku b LEFT JOIN penulis p ON b.id = p.id";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 1;
            while (rs.next()) {
                System.out.println("");
                System.out.println("Data ke-" + i);
                System.out.println("ID Buku : " + rs.getInt("id"));
                System.out.println("Judul Buku : " + rs.getString("judul_buku"));
                System.out.println("Tahun : " + rs.getInt("tahun"));
                System.out.println("Stok : " + rs.getInt("stok"));
                System.out.println("Penulis : " + rs.getString("nama_penulis"));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
