public class BinaryTree {

    class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrder(Node startingNode) {
        if (startingNode != null) {
            inOrder(startingNode.leftChild);
            System.out.print(startingNode.data + " ");
            inOrder(startingNode.rightChild);
        }
    }

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.insert(1);
        t.insert(3);
        t.insert(4);
        t.insert(6);
        t.insert(7);
        t.insert(2);
        t.insert(5);
        t.inOrder(t.root);
    }

}
