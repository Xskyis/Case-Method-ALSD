public class TransaksiPengisian {
    Kendaraan kendaraan;
    BBM bbm;
    double jumlahLiter;
    double totalBayar;

    public TransaksiPengisian(Kendaraan kendaraan, BBM bbm, double jumlahLiter) {
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.jumlahLiter = jumlahLiter;
        this.totalBayar = jumlahLiter * bbm.hargaPerLiter;
    }
}
