import java.util.Scanner;
public class SPBUMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKendaraan ak = new AntrianKendaraan();
        QueueTransaksi qt = new QueueTransaksi();
        int pilihan;
        do {
            System.out.println("\n=== SISTEM ANTRIAN SPBU ===");
            System.out.println("1. Tambah Kendaraan ke Antrian");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Lihat Jumlah Antrian");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor: ");
                    String plat = sc.nextLine();
                    System.out.print("Masukkan Jenis Kendaraan: ");
                    String tipe = sc.nextLine();
                    System.out.print("Masukkan Merk Kendaraan: ");
                    String merk = sc.nextLine();
                    Kendaraan kndrn = new Kendaraan(plat, tipe, merk);
                    ak.TambahAntrian(kndrn);
                    break;
                case 2:
                    ak.TampilkanAntrian();
                    break;
                case 3:
                    System.out.print(">> Jumlah Antrian Kendaraan: "+ak.jumlahAntrian());
                    System.out.println();
                    break;
                case 4:
                    if (ak.IsEmpty()) {
                        System.out.println("Tidak ada kendaraan dalam antrian.");
                        break;
                    }
                    System.out.println("Petugas Melayani Kendaraan: "+ak.head.data.platNomor);
                    System.out.print("Masukkan jenis BBM: ");
                    String bbm = sc.nextLine();
                    System.out.print("Masukkan harga per liter: ");
                    double harga = sc.nextDouble();
                    System.out.print("Masukkan jumlah liter: ");
                    double liter = sc.nextDouble();
                    sc.nextLine();
                    BBM bm = new BBM (bbm, harga);
                    Kendaraan kendaraanDilayani = ak.layaniKendaraan();
                    double totalBayar = harga * liter;
                    TransaksiPengisian transaksi = new TransaksiPengisian(kendaraanDilayani,bm, liter);
                    qt.tambahTransaksi(transaksi);
                    break;
                case 5: 
                    qt.tampilkanRiwayatTransaksi();
                    break;
                case 0: 
                    System.out.println("Terima Kasih.");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid.");
            }
        } while (pilihan != 0);
    }
    
}
