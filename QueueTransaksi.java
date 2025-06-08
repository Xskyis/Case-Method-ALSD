public class QueueTransaksi {
    TransaksiPengisian [] queue;
    int front;
    int rear;
    int size;
    int kapasitas = 10;
    QueueTransaksi (){
        queue = new TransaksiPengisian[kapasitas];
        front = 0;
        rear = -1;
        size = 0;
    } 
    boolean isEmpty (){
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }
    boolean isFull (){
        if (size == kapasitas){
            return true;
        } else {
            return false;
        }
    }
    void tambahTransaksi (TransaksiPengisian transaksi){
        if (isFull()){
            System.out.println("Queue Transaksi Penuh.");
            return;
        } 
        rear = rear +1 % kapasitas;
        queue[rear] = transaksi;
        size++;
        
    } 
    void tampilkanRiwayatTransaksi(){
        if (isEmpty()){
            System.out.println("Belum Ada Transaksi.");
            return;
        }
        System.out.println("== Riwayat Transaksi BBM ==");
        for (int i=0; i<size; i++){
            int index = (front+i) % kapasitas;
            TransaksiPengisian t = queue[index];
            System.out.print((i+1)+". ");
            t.tampilInformasi();
        }
    }
}
