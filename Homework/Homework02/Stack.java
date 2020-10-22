/**
 *  File name: Stack.java
 *  Purpose: implements a stack using a circular linked list
 * @author: Hayden Crabbs
 * @author: Natalia Cedeno
 */
public class Stack extends CircularList {

    private CircularList stack = new CircularList();

    /**
     * Constructor
     */
    public Stack() {
    }

    /**
     * Push data to top of stack
     * @param data int containing data to be pushed
     */
    public void push(int data) {
        Node node = new Node(data);
        if (stack.size == 0) {
            node.next = node;
            stack.setCurrent(node);
        } else {
            node.next = stack.getCurrent().next;
            stack.getCurrent().next = node;
        }
        stack.size++;
    }

    /**
     * Pop data off top of stack
     * @return int containing data popped off
     */
    public int pop() {
        int data = stack.getCurrent().next.data;
        stack.remove();
        System.out.println("\nPopped: " + data);
        return data;
    }

    /**
     * Peek at top of stack without removing data
     * @return int containing data
     */
    public int peek() {
        int data = stack.getCurrent().next.data;
        System.out.println("\nTop of stack: " + data);
        return data;
    }

    /**
     * Display stack with the top printed on top
     */
    public void display() {
        System.out.println();
        for (int i = 0; i < stack.size; i++) {
            stack.step();
            System.out.println("[" + stack.getCurrentData() + "]");
        }
    }

    /**
     * Main used to test methods
     * @param args
     */
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.display();
        s.peek();
        s.push(4);
        s.display();
        s.push(5);
        s.display();
        s.peek();
        s.pop();
        s.display();
        s.pop();
        s.display();
        s.peek();
    }
}
