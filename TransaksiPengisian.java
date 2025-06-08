public class TransaksiPengisian {
    Kendaraan kendaraan;
    BBM bbm;
    double liter;
    double totalBayar;
    TransaksiPengisian(Kendaraan kendaraan, BBM bbm, double liter){
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.liter = liter;
        this.totalBayar = liter * bbm.hargaPerLiter;
    } 
    void tampilInformasi (){
        kendaraan.tampilkanInformasi();
        System.out.println("BBM: "+bbm.namaBBM);
        System.out.println("Liter: "+liter);
        System.out.println("Total Bayar: "+totalBayar);
    }
}
