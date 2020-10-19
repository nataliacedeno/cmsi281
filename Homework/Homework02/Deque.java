public class Deque {
    Queue dQueue;
    private int maxSize; private int front; private int rear; private int nItems;
    public Deque(int s) {
        maxSize = s;
        dQueue = new Queue(s);
        rear = dQueue.getRear();
        front = dQueue.getFront();

    }
    public void insertRight(){
        dQueue.insert(rear);
    }
    public void insertLeft(){
        dQueue.insert(front);
    }
    
    public long removeLeft(){
        return dQueue.remove();
    }

    public long removeRight() {
        long temp = queArray[front++]; // get value and incr front 
        if(front == maxSize) {
            front = 0;
        } // deal with wraparound
        nItems--; // one less item 
        return temp;
    }

    public boolean isFull() {
        return dQueue.isFull();
    }
    public boolean isEmpty() {
        return dQueue.isEmpty();
    }

}
