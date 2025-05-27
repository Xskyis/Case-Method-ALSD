public class Kendaraan {
    String platNomor;
    String tipe;
    String merk;
    Kendaraan (String platnomor, String tipe, String merk){
        this.platNomor = platNomor;
        this.tipe = tipe;
        this.merk = merk;
    }
    void tampilInformasi(){
        System.out.println("Plat Nomor: "+platNomor);
        System.out.println("Tipe: "+tipe);
        System.out.println("Merk: "+merk);
    }

    
}