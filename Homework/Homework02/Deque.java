/**
 *  File name: Deque.java
 *  Purpose: implements a Deque using an array
 * @author: Hayden Crabbs
 * @author: Natalia Cedeno
 *  NOTES    : In this implementation, the "front" of the Deque will be considered
 *             to be the "left end", making the "rear" of the Deque the "right end".
 *             Implemented with an array of long primitives
 */
class Deque {
    private int maxSize; // max size at creation
    private long[] dequeArray; // the underlying storage
    private int rearLeft; // new way of looking at this ~ front is actually right
    private int rearRight; //    this makes things work more like what we expect
    private int nItems;

    /**
     * Empty Deque Exception
     */
    private class EmptyDequeException extends Exception {
        public EmptyDequeException(String s) {
            super(s);
        }
    }

    /**
    *  constructor
    *  @param s int for the size of the underlying array
    */
    public Deque(int s) {
        maxSize = s;
        dequeArray = new long[maxSize];
        nItems = 0;
        rearLeft = maxSize - 1;
        rearRight = 0;
    }

    /**
    *  put item at rear of deque
    *  @param j long primitive containing the value to insert
    */
    public void insertLeft(long j) {
        if (nItems == maxSize) {
            System.out.println("Dequeue full. Cannot insert.\n");
            return;
        } else {
            System.out.println("     ...inserting " + j + " at [" + rearLeft + "]");
            dequeArray[rearLeft--] = j;
            nItems++;
        }
    }

    /**
    *  put item at front of deque
    *  @param j long primitive containing the value to insert
    */
    public void insertRight(long j) {
        if (nItems == maxSize) {
            System.out.println("Dequeue full. Cannot insert.\n");
            return;
        } else {
            System.out.println("     ...inserting " + j + " at [" + rearRight + "]");
            dequeArray[rearRight++] = j;
            nItems++;
        }
    }

    /**
    *  remove item at front of deque
    *  @return long primitive containing the value removed
    */
    public long removeLeft() {
        long temp = dequeArray[rearLeft];
        try {
            if (getSize() == 0) {
                throw new EmptyDequeException("Dequeue empty. Cannot remove.\n");
            } else {
                nItems--;
                dequeArray[rearLeft++] = 0;
            }
        } catch (EmptyDequeException e) {
        }
        return temp; // return it
    }

    /**
    *  remove item at rear of deque
    *  @return long primitive containing the value removed
    */
    public long removeRight() {
        long temp = dequeArray[rearRight];
        try {
            if (getSize() == 0) {
                throw new EmptyDequeException("Dequeue empty. Cannot remove.\n");
            } else {
                nItems--;
                dequeArray[rearRight--] = 0;
            }
        } catch (EmptyDequeException e) {
        }
        return temp; // return it
    }

    /**
    *  peek at front of deque
    *  @return long primitive containing the value peeked at
    */
    public long peekFront() {
        return dequeArray[rearLeft];
    }

    /**
    *  peek at back of deque
    *  @return long primitive containing the value peeked at
    */
    public long peekBack() {
        return dequeArray[rearRight];
    }

    /**
    *  determine if the deque is empty
    *  @return boolean primitive containing true if deque is empty
    */
    public boolean isEmpty() {
        return (nItems == 0);
    }

    /**
    *  determine if the deque is full
    *  @return boolean primitive containing true if deque is full
    */
    public boolean isFull() {
        return (nItems == maxSize);
    }

    /**
    *  determine number of items in deque
    *  @return int primitive containing item count
    */
    public int getSize() {
        return nItems;
    }

    /**
    *  display the contents of the deque AS AN ARRAY
    *     note this is NOT NECESSARILY as a "Deque" view!
    */
    public void displayDequeArrayContents(boolean displayIndices) {
        if (displayIndices) {
            System.out.println(" rearLeft : " + rearLeft + "  rearRight: " + rearRight);
        }
        for (long i : dequeArray) {
            System.out.print("[" + i + "]");
        }
        System.out.println("");
    }

    /**
     * Main used to test methods
     * @param args
     */
    public static void main(String[] args) {
        Deque d = new Deque(5);
        d.insertRight(3);
        d.insertLeft(2);
        d.insertRight(4);
        d.insertLeft(1);
        d.insertRight(5);
        d.displayDequeArrayContents(true);
    }
}