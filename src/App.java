import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Koneksi.checkConnection();

        Service service = new Fotocopy(); // polymorphism
        int pilih;

        do {
            System.out.println("\n1. Tambah");
            System.out.println("2. Tampil");
            System.out.println("3. Ubah");
            System.out.println("4. Hapus");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");

            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1 -> service.tambah(sc);
                case 2 -> service.tampilkan();
                case 3 -> service.ubah(sc);
                case 4 -> service.hapus(sc);
            }

        } while (pilih != 5);

    }
}
