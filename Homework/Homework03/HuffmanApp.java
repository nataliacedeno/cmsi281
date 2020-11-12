import java.util.*;

public class HuffmanApp {
    public static Map<Character, Integer> sortedMap = new LinkedHashMap<>();
    public static Map<Character, String> encodedMap = new LinkedHashMap<>();
    public static Tree huffmanTree;
    public static String message;

    public static String input() {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String str = temp;

        while (temp.length() != 0) {
            temp = sc.nextLine();
            str = str + "\n" + temp;
        }
        sc.close();
        message = str;
        return str;
    }

    public static void makeSortedMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }

        ArrayList<Map.Entry<Character, Integer>> arrayList = new ArrayList<>(map.entrySet());

        Collections.sort(arrayList, Comparator.comparingInt((e) -> e.getValue()));

        for (Map.Entry<Character, Integer> e : arrayList) {
            sortedMap.put(e.getKey(), e.getValue());
        }

        System.out.println("Sorted Map:  " + sortedMap.toString());
    }

    public static void makeHuffmanTree() {
        Tree tempTree;
        ArrayList<Tree> priorityQueue = new ArrayList<>();

        for (Map.Entry<Character, Integer> e : sortedMap.entrySet()) {
            tempTree = new Tree();
            tempTree.insert(e.getKey(), e.getValue());
            priorityQueue.add(tempTree);
        }

        int initialSize = priorityQueue.size();

        for (int i = 0; i < initialSize - 1; i++) {
            int newCount = priorityQueue.get(0).root.count + priorityQueue.get(1).root.count;
            Tree newTree = new Tree();
            newTree.insert(newCount);
            newTree.insertLeft(priorityQueue.get(0).root);
            newTree.insertRight(priorityQueue.get(1).root);

            priorityQueue.remove(0);
            priorityQueue.remove(0);
            priorityQueue.add(newTree);
            Collections.sort(priorityQueue, Comparator.comparingInt((e) -> e.root.count));

        }
        huffmanTree = priorityQueue.get(0);
    }

    public static void makeEncodedMap() {
        Tree t = huffmanTree;
        encodedMap = new LinkedHashMap<>();
        for (Character c : sortedMap.keySet()) {
            encodedMap.put(c, "");
        }
        HuffmanNode current = t.root;
        HuffmanNode parent = t.root;
        String s = "";
        while (current != null) {
            if (current.letter == '~' && current.leftChild != null) {
                parent = current;
                current = current.leftChild;
                s += "0";
            } else if (current.letter != '~' || (current.leftChild == null && current.rightChild == null)) {
                if (current.letter != '~') {
                    encodedMap.put(current.letter, s);
                }

                if (s.endsWith("0")) {
                    parent.leftChild = null;
                } else if (s.endsWith("1")) {
                    parent.rightChild = null;
                } else if (s.equals("")) {
                    break;
                }
                current = t.root;
                parent = t.root;
                s = "";
            } else {
                parent = current;
                current = current.rightChild;
                s += "1";
            }
        }
        System.out.println("\nEncoded Map:  " + encodedMap.toString());
    }

    public static String encodeString() {
        char[] ca = message.toCharArray();
        String s = "";
        for (char c : ca) {
            s = s + encodedMap.get(c) + " ";
        }
        System.out.println("\nEncoded message: " + s);
        return s;
    }

    public static void decodeString(String encodedString) {
        String[] sa = encodedString.split(" ");
        String decodedString = "";
        HuffmanNode current;
        for (String s : sa) {
            char[] ca = s.toCharArray();
            current = huffmanTree.root;
            for (char c : ca) {
                if (c == '0') {
                    current = current.leftChild;
                } else if (c == '1') {
                    current = current.rightChild;
                }
            }
            decodedString += current.letter;
        }
        System.out.println("\nDecoded message: " + decodedString);
    }

    public static void main(String[] args) {
        makeSortedMap(input());
        makeHuffmanTree();
        makeEncodedMap();
        decodeString(encodeString());
    }
}
