// queue.java
// demonstrates queue
// to run this program: C>java QueueApp //////////////////////////////////////////////////////////////// 
public class Queue {
    private int maxSize; private long[] queArray; private int front; private int rear; private int nItems;
    public Queue(int s) {
    maxSize = s;
    queArray = new long[maxSize]; front = 0;
    rear = -1;
    nItems = 0;
    }

    public void insert(long j) {
        if(rear == maxSize-1) {
            rear = -1;
        }
        queArray[++rear] = j; 
        nItems++;
    }
    // put item at rear of queue // deal with wraparound
    // increment rear and insert // one more item
    public long remove() {
        long temp = queArray[front++]; // get value and incr front 
        if(front == maxSize) {
            front = 0;
        } // deal with wraparound
        nItems--; // one less item 
        return temp;
    }
    public long peekFront() {
        return queArray[front];
    } 
    public boolean isEmpty() {
        return (nItems==0);
    } 
    public boolean isFull() {
        return (nItems==maxSize);
    } 
    public int size() {
        return nItems;
    }

    public void display() {
        System.out.println("Print Queue...\n");
        for (int i=front, j=0;j<nItems;i++, j++){
            System.out.print(queArray[i]);
            if (j==queArray.length-1){
                i=0;
            }
        }
        System.out.println();
    }
    public int getFront(){
        return front;
    }
    public int getRear(){
        return rear;
    }
    
    public static void main(String[] args) {
        Queue myQueue = new Queue(5);
        myQueue.insert(1);
        myQueue.insert(2);
        myQueue.insert(3);
        myQueue.insert(4);
        myQueue.insert(5);
        myQueue.display();
        myQueue.remove();
        myQueue.display();
        myQueue.remove();
        myQueue.display();
    }
} 