class ArrayBub {
    private long[] a; // ref to array a
    private int nElems; // number of data items
    private boolean isSorted;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }
    // create the array // no items yet

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }
    // put element into array
    // insert it
    // increment size

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + "  ");
        }
        System.out.println("");
    }

    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--)
            for (in = 0; in < out; in++)
                if (a[in] > a[in + 1])
                    swap(in, in + 1);
        // outer loop (backward) // inner loop (forward) // out of order?
        // swap them
    }

    public void oddEvenSort() {
        isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i=1; i<nElems-1;i=i+2){
                if (a[i] > a[i+1]){
                    swap(i, i+1);
                    isSorted = false;
                }
            }
            for (int i=0; i<nElems-1; i=i+2){
                if (a[i] > a[i+1]){
                    swap(i, i+1);
                    isSorted = false;
                }
            }
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public static void main(String[] args) {
        ArrayBub array = new ArrayBub(7);
        array.insert(12);
        array.insert(4);
        array.insert(3);
        array.insert(627);
        array.insert(9);
        array.insert(0);
        array.insert(9);
        array.display();
        array.oddEvenSort();
        array.display();
    }
}