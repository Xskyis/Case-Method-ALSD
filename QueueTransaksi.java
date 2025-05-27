public class QueueTransaksi {
    TransaksiPengisian[] queue;
    int front;
    int rear;
    int size;
    int kapasitas = 100;
    
    public QueueTransaksi() {
        this.queue = new TransaksiPengisian[kapasitas];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    // Menambahkan transaksi ke queue (Enqueue)
    public void tambahTransaksi(TransaksiPengisian transaksi) {
        if (size >= kapasitas) {
            System.out.println("Queue transaksi penuh!");
            return;
        }
        
        rear = (rear + 1);
        queue[rear] = transaksi;
        size++;
        System.out.println("Transaksi berhasil dicatat.");
    }
    
    // Menampilkan riwayat transaksi
    public void tampilkanRiwayatTransaksi() {
        if (size == 0) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        
        System.out.println("\n=== RIWAYAT TRANSAKSI BBM ===");
        for (int i = 0; i < size; i++) {
            int index = (front + i);
            TransaksiPengisian t = queue[index];
            System.out.println((i + 1) + ". Kendaraan: " + t.kendaraan.platNomor + 
                             ", BBM: " + t.bbm.namaBBM + 
                             ", Liter: " + t.jumlahLiter + 
                             ", Total: Rp " + String.format("%.2f", t.totalBayar));
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int getSize() {
        return size;
    }
}
