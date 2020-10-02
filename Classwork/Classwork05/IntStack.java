public class IntStack {

    IntLinkedList myStack;

    IntStack() {
        myStack = new IntLinkedList(); // constructor
    }

    public void push(int itemToPush) {
        myStack.prepend(itemToPush);
    }

    public int peek() {
        return myStack.getIteratorAt(0).getCurrentInt(); // we use the iterator
    }

    public int pop() {
        return myStack.removeAt(0);
    }

    public static void main(String[] args) {
        IntStack testStack = new IntStack();
        testStack.push(19);
        testStack.push(23);
        testStack.push(29);
        testStack.push(31);
        testStack.push(37);
        testStack.push(41);
        testStack.push(43);
        testStack.push(47);
        testStack.push(51);
        testStack.push(57);
        System.out.println("The top of the stack: " + testStack.peek()); // 57
        System.out.println("Removing top thing: " + testStack.pop()); // 57 removed
        System.out.println("The top of the stack: " + testStack.peek()); // 51
        System.out.println("Removing top thing: " + testStack.pop()); // 51 removed
        System.out.println("The top of the stack: " + testStack.peek()); // 47
        System.out.println("Removing top thing: " + testStack.pop()); // 47 removed
        System.out.println("The top of the stack: " + testStack.peek()); // 43
        testStack.push(testStack.pop() + testStack.pop());
        System.out.println("The top of the stack: " + testStack.peek()); // what'll it be?
    }

}