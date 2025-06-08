public class AntrianKendaraan {
    Node head;
    Node tail;
    int size;
    AntrianKendaraan (){
        head = null;
        tail = null;
        size = 0;
    }
    boolean IsEmpty (){
        if (head == null){
            return true;
        } else {
            return false;
        }
    }
    void TambahAntrian(Kendaraan kendaraan){
        Node newNode = new Node(kendaraan);
        if (IsEmpty()){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println(">> Kendaraan Dengan Plat Nomor "+kendaraan.platNomor+" Berhasil Ditambahkan.");
    }
    void TampilkanAntrian(){
        if (IsEmpty()){
            System.out.println("Antrian Kosong.");
            return;
        } 
        System.out.println("== Daftar Antrian Kendaraan ==");
        Node current = head;
        int no = 1;
        while (current != null){
            System.out.print(no+". ");
            current.data.tampilkanInformasi();
            current = current.next;
            no++;
        }
    }
    Kendaraan layaniKendaraan (){
        Kendaraan dilayani = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        System.out.println(">> Transaksi Berhasil Dicatat.");
        return dilayani;
    }
    int jumlahAntrian(){
        return size;
    }
}
