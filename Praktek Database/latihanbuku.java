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
            System.out.println("5. Keluar");
            System.out.print("Masukkan Opsi Pilihan: ");
            
            int choice = getInputInt(scanner);
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1: insert(scanner); break;
                case 2: update(scanner); break;
                case 3: delete(scanner); break;
                case 4: show(); break;
                case 5: System.out.println("Exiting..."); scanner.close(); return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }
    
    public static int getInputInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input yang dimasukkan tidak valid. Tolong masukkan input yang benar.");
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
            System.out.print("Masukkan ID Buku: ");
            int id = getInputInt(scanner);
            scanner.nextLine(); // Consume newline
            
            System.out.print("Judul Buku: ");
            String judul_buku = scanner.nextLine();
            System.out.print("Tahun: ");
            int tahun = getInputInt(scanner);
            System.out.print("Stok: ");
            int stok = getInputInt(scanner);
            scanner.nextLine(); // Consume newline
            System.out.print("Penulis: ");
            String penulis = scanner.nextLine();
            
            String sql = "INSERT INTO buku (id, judul_buku, tahun, stok, penulis) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, judul_buku);
            ps.setInt(3, tahun);
            ps.setInt(4, stok);
            ps.setString(5, penulis);
            ps.execute();
            
            System.out.println("Data telah sukses dimasukkan ke database .");
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
                System.out.println("Data saat ini:");
                System.out.println("ID Buku: " + rs.getInt("id"));
                System.out.println("Judul Buku: " + rs.getString("judul_buku"));
                System.out.println("Tahun: " + rs.getInt("tahun"));
                System.out.println("Stok: " + rs.getInt("stok"));
                System.out.println("Penulis: " + rs.getString("penulis"));
                
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
                
                sql = "UPDATE buku SET judul_buku = ?, tahun = ?, stok = ?, penulis = ? WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, judul_buku);
                ps.setInt(2, tahun);
                ps.setInt(3, stok);
                ps.setString(4, penulis);
                ps.setInt(5, id);
                ps.execute();
                
                System.out.println("Data berhasil di update.");
            } else {
                System.out.println("No data tidak ditemukan dengan ID buku : " + id);
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
            System.out.print("Masukkan ID Buku yang ingin dihapus: ");
            int id = getInputInt(scanner);
            scanner.nextLine(); // Consume newline
            
            String sql = "DELETE FROM buku WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Data deleted successfully.");
            } else {
                System.out.println("No data found with ID Buku: " + id);
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
            String sql = "SELECT * FROM buku";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 1;
            while (rs.next()) {
                System.out.println("\nData ke-" + i);
                System.out.println("ID Buku: " + rs.getInt("id"));
                System.out.println("Judul Buku: " + rs.getString("judul_buku"));
                System.out.println("Tahun: " + rs.getInt("tahun"));
                System.out.println("Stok: " + rs.getInt("stok"));
                System.out.println("Penulis: " + rs.getString("penulis"));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
}