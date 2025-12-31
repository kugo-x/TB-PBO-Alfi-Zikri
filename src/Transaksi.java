import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaksi {

    private int id;
    private LocalDate tanggalTransaksi;
    private String namaPelanggan;
    private double totalBayar;

    public Transaksi(int id, String namaPelanggan, double totalBayar) {
        this.id = id;
        this.namaPelanggan = namaPelanggan;
        this.totalBayar = totalBayar;
        this.tanggalTransaksi = LocalDate.now(); // otomatis ambil tanggal hari ini
    }

    public int getId() {
        return id;
    }

    public String getNamaPelanggan() {
        return namaPelanggan.toUpperCase(); // manipulasi String
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public LocalDate getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getTanggalFormatted() {
        DateTimeFormatter formatter = 
                DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return tanggalTransaksi.format(formatter); 
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Nama: " + getNamaPelanggan() +
               ", Total Bayar: " + totalBayar +
               ", Tanggal: " + getTanggalFormatted();
    }
}
