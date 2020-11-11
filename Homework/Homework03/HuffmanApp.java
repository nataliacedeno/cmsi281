import java.util.*;

public class HuffmanApp {
    public static Map<Character, Integer> sortedMap = new LinkedHashMap<>();
    public static ArrayList<Tree> priorityQueue = new ArrayList<>();

    public static String input() {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String str = temp;

        while (temp.length() != 0) {
            temp = sc.nextLine();
            str = str + "\n" + temp;
        }
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
        System.out.println(map.toString());

        ArrayList<Map.Entry<Character, Integer>> arrayList = new ArrayList<>(map.entrySet());

        Collections.sort(arrayList, Comparator.comparingInt((e) -> e.getValue()));

        for (Map.Entry<Character, Integer> e : arrayList) {
            sortedMap.put(e.getKey(), e.getValue());
        }

        System.out.println(sortedMap.toString());
    }

    public static void makeHuffmanTree() {
        Tree tempTree;
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
            newTree.insert(priorityQueue.get(0).root);
            newTree.insert(priorityQueue.get(1).root);

            priorityQueue.remove(0);
            priorityQueue.remove(0);
            priorityQueue.add(newTree);
            Collections.sort(priorityQueue, Comparator.comparingInt((e) -> e.root.count));
        }
    }

    public static void encodeTree() {
        Tree t = priorityQueue.get(0);
        Map m = sortedMap;

    }

    public static void main(String[] args) {
        makeSortedMap(input());
        makeHuffmanTree();
    }
}
