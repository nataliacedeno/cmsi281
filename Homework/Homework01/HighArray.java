import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HighArray {
    private long[] a;
    private int nElems;
    private int max;

    public HighArray(int max) {
        this.max = max;
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] == searchKey)
                break;
        if (j == nElems)
            return false;
        else
            return true;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (value == a[j])
                break;
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    public long getMax() {
        if (nElems == 0) {
            return -1;
        } else {
            return Arrays.stream(a).max().getAsLong();
        }
    }

    public void noDups() {
        LinkedHashSet<Long> set = new LinkedHashSet<>();
        for (int i = 0; i < nElems; i++) {
            set.add(a[i]);
        }

        nElems = set.size();
        a = new long[max];

        Iterator<Long> itr = set.iterator();

        for (int i = 0; i < nElems; i++) {
            a[i] = itr.next();
        }
    }
}