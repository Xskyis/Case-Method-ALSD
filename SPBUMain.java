import java.util.Scanner;

public class SPBUMain {
    AntrianKendaraan antrian;
    QueueTransaksi queueTransaksi;

    public SPBUMain() {
        antrian = new AntrianKendaraan();
        queueTransaksi = new QueueTransaksi();
    }

    // Method untuk menambah kendaraan ke antrian
    public void tambahKendaraanKeAntrian(String platNomor, String tipe, String merk) {
        Kendaraan kendaraan = new Kendaraan(platNomor, tipe, merk);
        antrian.tambahAntrian(kendaraan);
    }

    // Method untuk melayani kendaraan
    public void layaniKendaraan(String namaBBM, double hargaPerLiter, double jumlahLiter) {
        if (antrian.isEmpty()) {
            System.out.println("Tidak ada kendaraan dalam antrian!");
            return;
        }

        Kendaraan kendaraanDilayani = antrian.layaniKendaraan();
        BBM bbm = new BBM(namaBBM, hargaPerLiter);
        TransaksiPengisian transaksi = new TransaksiPengisian(kendaraanDilayani, bbm, jumlahLiter);

        queueTransaksi.tambahTransaksi(transaksi);

        System.out.println(">> Transaksi berhasil dicatat");
    }

    // Method untuk menampilkan menu
    public void tampilkanMenu() {
        System.out.println("\n=== SISTEM ANTRIAN SPBU ===");
        System.out.println("1. Tambah Kendaraan ke Antrian");
        System.out.println("2. Tampilkan Antrian");
        System.out.println("3. Lihat Jumlah Antrian");
        System.out.println("4. Layani Kendaraan");
        System.out.println("5. Tampilkan Riwayat Transaksi");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }

    // Main
    public static void main(String[] args) {
        SPBUMain sistem = new SPBUMain();
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            sistem.tampilkanMenu();
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan plat nomor: ");
                    String plat = sc.nextLine();
                    System.out.print("Masukkan jenis kendaraan: ");
                    String tipe = sc.nextLine();
                    System.out.print("Masukkan merk kendaraan: ");
                    String merk = sc.nextLine();
                    sistem.tambahKendaraanKeAntrian(plat, tipe, merk);
                    break;

                case 2:
                    sistem.antrian.tampilkanAntrian();
                    break;

                case 3:
                    System.out.println("Jumlah kendaraan dalam antrian: " +
                            sistem.antrian.getJumlahAntrian());
                    break;

                case 4:
                    if (sistem.antrian.isEmpty()) {
                        System.out.println("Antrian kosong!");
                        break;
                    }
                    System.out.println("Petugas Melayani Kendaraan: " + sistem.antrian.head.data.platNomor);
                    System.out.print("Masukkan jenis BBM: ");
                    String bbm = sc.nextLine();
                    System.out.print("Masukkan harga per liter: ");
                    double harga = sc.nextDouble();
                    System.out.print("Masukkan jumlah liter: ");
                    double liter = sc.nextDouble();
                    sistem.layaniKendaraan(bbm, harga, liter);
                    break;

                case 5:
                    sistem.queueTransaksi.tampilkanRiwayatTransaksi();
                    break;

                case 0:
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
}
