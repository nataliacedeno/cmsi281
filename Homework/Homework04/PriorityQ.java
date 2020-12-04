import java.io.IOException;

class PriorityQ {
    private int maxSize;
    private Heap queHeap;
    private int nItems;

    public PriorityQ(int s) {
        maxSize = s;
        queHeap = new Heap(s);
        nItems = 0;
    }

    public void insert(int item) {
        queHeap.insert(item);
        nItems++;
    }

    public int remove() {
        nItems--;
        return queHeap.remove().getKey();
    }

    // public long peekMax() {
    //     return queHeap.heapArray[0];
    // }

    public boolean isEmpty() {
        return queHeap.isEmpty();
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

}

class PriorityQApp {
    public static void main(String[] args) throws IOException {
        PriorityQ thePQ = new PriorityQ(5);
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        while (!thePQ.isEmpty()) {
            long item = thePQ.remove();
            System.out.print(item + " ");
        }
        System.out.println("");
    }
}