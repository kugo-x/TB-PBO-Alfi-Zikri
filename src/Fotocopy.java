import java.util.Map;
import java.util.HashMap;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Fotocopy extends Service {

    public Fotocopy() {
        super("Fotocopy", 200); // harga per lembar
    }

    @Override
    public void tambah(Scanner sc) {
        try {
            System.out.print("Nama Pelanggan: ");
            String nama = sc.nextLine();

            System.out.print("Jumlah Lembar: ");
            int jumlah = sc.nextInt();
            sc.nextLine();

            double total = hitungTotal(jumlah);

            String sql =
              "INSERT INTO transaksi " +
              "(tanggal_transaksi, nama_pelanggan, total_bayar) " +
              "VALUES (?, ?, ?)";

            Connection conn = Koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setString(2, nama);
            ps.setDouble(3, total);

            ps.executeUpdate();
            System.out.println("Transaksi fotocopy berhasil.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    
public void tampilkan() {
      Map<Integer, String> dataTransaksi = new HashMap<>();
    try {
        String sql = "SELECT * FROM transaksi";
        Connection conn = Koneksi.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\n=== DATA TRANSAKSI FOTOCOPY ===");
        System.out.println("ID | Tanggal | Nama Pelanggan | Total Bayar");

        while (rs.next()) {
            dataTransaksi.put(rs.getInt("id"),
                rs.getDate("tanggal_transaksi") + " | " +
                rs.getString("nama_pelanggan") + " | " +
                rs.getDouble("total_bayar"));
        }

        for (Map.Entry<Integer, String> entry : dataTransaksi.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }

    } catch (SQLException e) {
        System.out.println("Gagal menampilkan data.");
        e.printStackTrace();
    }
}

   @Override
public void ubah(Scanner sc) {
    try {
        System.out.print("Masukkan ID Transaksi: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nama Pelanggan Baru: ");
        String nama = sc.nextLine();

        System.out.print("Total Bayar Baru: ");
        double total = sc.nextDouble();

        String sql =
            "UPDATE transaksi " +
            "SET nama_pelanggan = ?, total_bayar = ? " +
            "WHERE id = ?";

        Connection conn = Koneksi.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, nama);
        ps.setDouble(2, total);
        ps.setInt(3, id);

        int hasil = ps.executeUpdate();

        if (hasil > 0) {
            System.out.println("Transaksi berhasil diubah.");
        } else {
            System.out.println("ID tidak ditemukan.");
        }

    } catch (SQLException e) {
        System.out.println("Gagal mengubah transaksi.");
        e.printStackTrace();
    }
}


   @Override
public void hapus(Scanner sc) {
    try {
        System.out.print("Masukkan ID Transaksi: ");
        int id = sc.nextInt();

        String sql =
            "DELETE FROM transaksi WHERE id = ?";

        Connection conn = Koneksi.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);

        int hasil = ps.executeUpdate();

        if (hasil > 0) {
            System.out.println("Transaksi berhasil dihapus.");
        } else {
            System.out.println("ID tidak ditemukan.");
        }

    } catch (SQLException e) {
        System.out.println("Gagal menghapus transaksi.");
        e.printStackTrace();
    }
}
}
