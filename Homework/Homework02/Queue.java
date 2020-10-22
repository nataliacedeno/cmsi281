/**
 * File name: Queue.java
 * Purpose: implements a Queue using an array
 * 
 */
public class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    /**
     * Constructor
     * @param s int maximum size of Queue
     */
    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * Inserts item to rear of queue
     * @param j long contains value to be insterted
     */
    public void insert(long j) {
        if (isFull()) {
            System.out.println("Queue full. Cannot insert.\n");
            return;
        } else if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    /**
     * Remove item from Queue
     * @return long contains value removed
     */
    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    /**
     * Peek front item of Queue
     * @return long contains front item
     */
    public long peekFront() {
        return queArray[front];
    }

    /**
     * Check if empty
     * @return boolean 
     */
    public boolean isEmpty() {
        return (nItems == 0);
    }

    /**
     * Check if full
     * @return boolean 
     */
    public boolean isFull() {
        return (nItems == maxSize);
    }

    /**
     * Get size of Queue
     * @return int size of Queue 
     */
    public int size() {
        return nItems;
    }

    /**
     * Displays Queue with front on left and rear on right
     */
    public void display() {
        System.out.println("Printing Queue...");
        for (int i = front, j = 0; j < nItems; j++) {
            System.out.print("[" + queArray[i] + "]");
            if (i == queArray.length - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        System.out.println("\n");
    }

    /**
     * Get index of front of Queue
     * @return int index of front
     */
    public int getFront() {
        return front;
    }

    /**
     * Get index of rear of Queue
     * @return int index of rear
     */
    public int getRear() {
        return rear;
    }

    /**
     * Used to test methods
     */
    public static void main(String[] args) {
        Queue myQueue = new Queue(5);
        myQueue.insert(1);
        myQueue.insert(2);
        myQueue.insert(3);
        myQueue.insert(4);
        myQueue.insert(5);
        myQueue.display();
        System.out.println("\nRemoving...");
        myQueue.remove();
        myQueue.display();
        System.out.println("\nRemoving...");
        myQueue.remove();
        myQueue.display();
        System.out.println("\nInserting 2...");
        myQueue.insert(6);
        myQueue.insert(7);
        myQueue.display();
        System.out.println("\nInserting 1...");
        myQueue.insert(8);
        myQueue.display();
    }
}