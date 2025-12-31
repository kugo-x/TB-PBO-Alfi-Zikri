public abstract class Service implements CRUD {

    protected String namaLayanan;
    protected double hargaSatuan;

    public Service(String namaLayanan, double hargaSatuan) {
        this.namaLayanan = namaLayanan;
        this.hargaSatuan = hargaSatuan;
    }

    public double hitungTotal(int jumlah) {
        return jumlah * hargaSatuan;
    }
}
