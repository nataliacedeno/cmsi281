public class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

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

    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }

    public void display() {
        System.out.println("Printing Queue...\n");
        for (int i = front, j = 0; j < nItems; j++) {
            System.out.print(queArray[i]);
            if (i == queArray.length - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        System.out.println("\n");
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
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
        myQueue.insert(6);
        myQueue.insert(7);
        myQueue.display();
        myQueue.insert(8);
        myQueue.display();
    }
}