public class AntrianKendaraan {
    Node head;
    Node tail;
    int size;
    
    public AntrianKendaraan() {
        head = null;
        tail = null;
        size = 0;
    }
    
    // Menambahkan kendaraan ke antrian (Linked List Insert Di tail)
    public void tambahAntrian(Kendaraan kendaraan) {
        Node newNode = new Node(kendaraan);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Kendaraan " + kendaraan.platNomor + " ditambahkan ke antrian.");
    }
    
    // Melayani kendaraan (hapus dari antrian di head)
    public Kendaraan layaniKendaraan() {
        if (head == null) {
            System.out.println("Antrian kosong!");
            return null;
        }
        
        Kendaraan dilayani = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return dilayani;
    }
    
    // Menampilkan antrian (Traverse)
    public void tampilkanAntrian() {
        if (head == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        
        System.out.println("\n=== DAFTAR ANTRIAN KENDARAAN ===");
        Node current = head;
        int urutan = 1;
        while (current != null) {
            System.out.println(urutan + ". Plat: " + current.data.platNomor + ", Tipe: " + current.data.tipe + ", Merk: " + current.data.merk);
            current = current.next;
            urutan++;
        }
    }
    
    // Mendapatkan jumlah kendaraan dalam antrian
    public int getJumlahAntrian() {
        return size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
}
