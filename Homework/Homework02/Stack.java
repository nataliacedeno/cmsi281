public class Stack extends CircularList {
    private CircularList stack = new CircularList();

    public Stack() {
    }

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

    public int pop() {
        int data = stack.getCurrent().next.data;
        stack.remove();
        System.out.println("\nPopped: " + data);
        return data;
    }

    public int peek() {
        int data = stack.getCurrent().next.data;
        System.out.println("\nTop of stack: " + data);
        return data;
    }

    public void display() {
        System.out.println();
        for (int i = 0; i < stack.size; i++) {
            stack.step();
            System.out.println("[" + stack.getCurrentData() + "]");
        }
    }

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
