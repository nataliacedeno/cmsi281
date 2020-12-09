import java.security.Key;

public class HashFunction {
    public static int arraySize = 10;
    public static int[] array = new int[arraySize];
    
    public void hash(int key) {
        int value = 0;
        int digits = String.valueOf(arraySize).length() - 1;
        char[] keyDigits = String.valueOf(key).toCharArray();
        int[] folding = new int[keyDigits.length/digits];
        String s;
        for (int i=0; i<folding.length-1; i++){
            s = "";
            for(int j=i*digits; j<digits; j++){
                s += keyDigits[j];
            }
            System.out.println("S:" + s);
            folding[i] = Integer.parseInt(s);
            System.out.println("Group:" + folding[i]);
        }

        for (int i : folding) {
            value += i;
            System.out.print(i + " ");
        }
        value %= arraySize;
        while (array[value]!= 0) {
            value++;
            if (value >= arraySize){
              value = 0;
            }
          }
          array[value] = key;
    }
    public static void main(String[] args){
        HashFunction test = new HashFunction();
        test.hash(12345);
        test.hash(274);
        test.hash(54321);
        for(int myInt : array) {
          System.out.println(myInt);
        }
      }
}
