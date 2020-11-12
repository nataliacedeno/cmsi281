public class HuffmanNode {
    public int count; // data item (key)
    public char letter; // data item
    public HuffmanNode leftChild; // this node’s left child
    public HuffmanNode rightChild; // this node’s right child

    public HuffmanNode() {
        letter = '~';
    }
    public void displayNode() // display ourself
    {
        System.out.print('{');
        System.out.print(count);
        System.out.print(", ");
        System.out.print(letter);
        System.out.print("} ");
    }
}
