import java.util.*;

public class HuffmanApp {
    public static String input(){
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String str = temp;

        while (temp.length() != 0){
            temp = sc.nextLine();
            str = str + "\n" + temp;
        }
        return str;
    }

    public static void countOccurances(String s){
        HashMap<Character,Integer> map = new HashMap<>();
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
    }
    public static void main(String[] args){
        countOccurances(input());
    }
}
