public class IntQueue {
    IntStack stack;

    public IntQueue() {
        stack = new IntStack();
    }

    public void push(int item) {
        stack.push(item);
    }

    public int peek() {
        return stack.myStack.getIteratorAt(stack.myStack.getSize() - 1).getCurrentInt();
    }

    public int remove() {
        return stack.myStack.removeAt(stack.myStack.getSize() - 1);
    }

    public static void main(String[] args) {
        IntQueue testQueue = new IntQueue();
        testQueue.push(19);
        testQueue.push(23);
        testQueue.push(29);
        testQueue.push(31);
        testQueue.push(37);
        testQueue.push(41);
        testQueue.push(43);
        testQueue.push(47);
        testQueue.push(51);
        testQueue.push(57);
        System.out.println("The first item in queue: " + testQueue.peek()); // 57
        System.out.println("Removing first item: " + testQueue.remove()); // 19 removed
        System.out.println("The first item in queue: " + testQueue.peek()); // 57
        System.out.println("Removing first item: " + testQueue.remove()); // 51 removed
        System.out.println("The first item in queue: " + testQueue.peek()); // 47
        System.out.println("Removing first item: " + testQueue.remove()); // 47 removed
        System.out.println("The first item in queue: " + testQueue.peek()); // 43
        testQueue.push(testQueue.remove() + testQueue.remove());
        System.out.println("The first item in queue: " + testQueue.peek()); // what'll it be?

        IntLinkedList.Iterator myIt = testQueue.stack.myStack.getIteratorAt(0);
        System.out.println("Current Node is: " + myIt.getCurrentInt()); // 2
        myIt.next();
        System.out.println("Current Node is: " + myIt.getCurrentInt()); // 3
        myIt.next();
        System.out.println("Current Node is: " + myIt.getCurrentInt()); // 5
        myIt.next();
        System.out.println("Current Node is: " + myIt.getCurrentInt()); // 7
        myIt.next();
        System.out.println("Current Node is: " + myIt.getCurrentInt()); // 11
        myIt.next();
        System.out.println("Current Node is: " + myIt.getCurrentInt()); // 13

    }
}