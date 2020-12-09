public class HashTable {
    public static int arraySize = 10;
    public static String[] array = new String[arraySize];

    public void linearProbeHash(String key) {
        int value = 0;
        for(int i=0; i<key.length(); i++) {
          int letter = key.charAt(i) - 96;
          value = (value * 27 + letter) % arraySize;
        }
        while (array[value]!= null) {
          value++;
          if (value >= arraySize){
            value = 0;
          }
        }
        array[value] = key;
    }
    
    public static void main(String[] args){
      HashTable test = new HashTable();
      test.linearProbeHash("hi");
      test.linearProbeHash("anything");
      test.linearProbeHash("hi");
      for(String s : array) {
        System.out.println(s);
      }
    }
}
