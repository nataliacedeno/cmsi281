public class Stack {
    private CircularList stack = new CircularList();
    private int size;
    private int stackPointer;

    public Stack() {
        size = 0;
        stackPointer = -1;
    }

    public void push(int data) {
        stack.insert(data);
        size++;
    }

    public int pop() {
        int temp = stack.getCurrentData();
        stack.remove();
        size--;
        return temp;
    }

    public int peek() {
        return stack.getCurrentData();
    }

    public void display() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.println("[" + stack.getCurrentData() + "]");
            stack.step();
        }
        // System.out.println("\nCurrent: " + current.next.data);
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.display();
        s.push(3);
        s.display();
        s.push(4);
        s.display();
        s.push(5);
        s.display();
        s.pop();
        s.display();
        s.pop();
        s.display();
    }
}
