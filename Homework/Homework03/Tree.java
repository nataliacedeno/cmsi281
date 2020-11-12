public class Tree {

    public HuffmanNode root;

    public Tree() {
        root = null;
    }

    public HuffmanNode find(int key) {
        HuffmanNode current = root;
        while (current.count != key) {
            if (key < current.count) {// go left?
                current = current.leftChild;
            } else {// or go right?
                current = current.rightChild;
            }
            if (current == null) {// if no child,
                return null;
            } // didn’t find it
        }
        return current;
    }

    public void insert(char letter, int count) {
        HuffmanNode newHuffmanNode = new HuffmanNode();
        newHuffmanNode.count = count; // insert data
        newHuffmanNode.letter = letter;
        if (root == null) // no HuffmanNode in root
            root = newHuffmanNode;
        else {
            HuffmanNode current = root; // start at root
            HuffmanNode parent;
            while (true) {
                parent = current;
                if (count < current.count) { // go left?
                    current = current.leftChild;
                    if (current == null) { // if end of the line, insert on left
                        parent.leftChild = newHuffmanNode;
                        return;
                    }
                } else { // or go right?
                    current = current.rightChild;
                    if (current == null) { // if end of the line, insert on right
                        parent.rightChild = newHuffmanNode;
                        return;
                    }
                }
            }
        }
    }

    public void insert(int count) {
        HuffmanNode newHuffmanNode = new HuffmanNode();
        newHuffmanNode.count = count; // insert data
        if (root == null) // no HuffmanNode in root
            root = newHuffmanNode;
        else {
            HuffmanNode current = root; // start at root
            HuffmanNode parent;
            while (true) {
                parent = current;
                if (count < current.count) { // go left?
                    current = current.leftChild;
                    if (current == null) { // if end of the line, insert on left
                        parent.leftChild = newHuffmanNode;
                        return;
                    }
                } else { // or go right?
                    current = current.rightChild;
                    if (current == null) { // if end of the line, insert on right
                        parent.rightChild = newHuffmanNode;
                        return;
                    }
                }
            }
        }
    }

    // public void insertLeft(HuffmanNode node) {
    //     HuffmanNode newHuffmanNode = node;
    //     if (root == null) // no HuffmanNode in root
    //         root = newHuffmanNode;
    //     else {
    //         HuffmanNode current = root; // start at root
    //         HuffmanNode parent;
    //         while (true) {
    //             parent = current;
    //             if (newHuffmanNode.count < current.count) { // go left?
    //                 current = current.leftChild;
    //                 if (current == null) { // if end of the line, insert on left
    //                     parent.leftChild = newHuffmanNode;
    //                     return;
    //                 }
    //             } else { // or go right?
    //                 current = current.rightChild;
    //                 if (current == null) { // if end of the line, insert on right
    //                     parent.rightChild = newHuffmanNode;
    //                     return;
    //                 }
    //             }
    //         }
    //     }
    // }

    public void insertLeft(HuffmanNode node) {
        HuffmanNode newHuffmanNode = node;
        if (root == null) // no HuffmanNode in root
            root = newHuffmanNode;
        else {
            root.leftChild = node;
        }
    }

    public void insertRight(HuffmanNode node) {
        HuffmanNode newHuffmanNode = node;
        if (root == null) // no HuffmanNode in root
            root = newHuffmanNode;
        else {
            root.rightChild = node;
        }
    }

    public boolean delete(int key) {
        HuffmanNode current = root;
        HuffmanNode parent = root;
        boolean isLeftChild = true;
        while (current.count != key) { // search for HuffmanNode
            parent = current;
            if (key < current.count) { // go left?
                isLeftChild = true;
                current = current.leftChild;
            } else { // or go right?
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {// end of the line, didn’t find it
                return false;
            }
        }
        // if no children, simply delete it
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        // if no right child, replace with left subtree
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }
        // if no left child, replace with right subtree
        else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        }
        // two children, so replace with inorder successor
        else {
            // get successor of HuffmanNode to delete (current)
            HuffmanNode successor = getSuccessor(current);
            // connect parent of current to successor instead
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            // connect successor to current’s left child
            successor.leftChild = current.leftChild;
        }
        return true; // success
    }

    private HuffmanNode getSuccessor(HuffmanNode delHuffmanNode) {
        HuffmanNode successorParent = delHuffmanNode;
        HuffmanNode successor = delHuffmanNode;
        HuffmanNode current = delHuffmanNode.rightChild; // go to right child
        while (current != null) // until no more
        { // left children,
            successorParent = successor;
            successor = current;
            current = current.leftChild; // go to left child
        }
        // if successor not
        if (successor != delHuffmanNode.rightChild) // right child,
        { // make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delHuffmanNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(HuffmanNode localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.count + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    public void inOrder(HuffmanNode localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.count + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(HuffmanNode localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.count + " ");
        }
    }

}
