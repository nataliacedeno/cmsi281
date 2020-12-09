public class HashFunction {
  public static int arraySize = 100;
  public static int[] array = new int[arraySize];
  public int currentSize;

  public void hash(int key) {
    int value = 0;
    int digits = String.valueOf(arraySize).length() - 1;
    String keyString = String.valueOf(key);
    int[] folding = new int[(int) Math.ceil((double) keyString.length() / (double) digits)];

    for (int i = 0, j = 0; i < folding.length - 1; i++, j += digits) {
      folding[i] = Integer.parseInt(keyString.substring(j, j + digits));
    }
    if (keyString.length() % digits != 0) {
      folding[folding.length - 1] = Integer
          .parseInt(keyString.substring(keyString.length() - keyString.length() % digits));
    } else {
      folding[folding.length - 1] = Integer.parseInt(keyString.substring(keyString.length() - digits));
    }

    for (int i : folding) {
      System.out.println(i);
      value += i;
    }
    value %= arraySize;
    while (array[value] != 0) {
      value++;
      if (value >= arraySize) {
        value = 0;
      }
    }
    array[value] = key;
  }

  public static void main(String[] args) {
    HashFunction test = new HashFunction();
    test.hash(12345);
    test.hash(274);
    test.hash(54321);
    test.hash(111111111);
    for (int myInt : array) {
      System.out.println(myInt);
    }
  }
}
