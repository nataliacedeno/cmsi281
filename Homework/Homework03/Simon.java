import java.util.Scanner;

public class Simon {

    public static String input = "";
    public static String str = "";

    public static char randomLetter() {
        char c = ' ';
        int n = (int) Math.floor(Math.random() * 4 + 1);
        switch (n) {
            case 1:
                c = 'R';
                break;
            case 2:
                c = 'G';
                break;
            case 3:
                c = 'Y';
                break;
            case 4:
                c = 'B';
                break;
        }
        return c;
    }

    public static boolean checkInput() {
        return input.toUpperCase().equals(str);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nGet Ready to Start!");
        long oldTime = System.currentTimeMillis();
        long currentTime = 0;
        while (currentTime - oldTime < 2000) {
            currentTime = System.currentTimeMillis();
        }

        while (true) {
            int round = 1;
            while (checkInput()) {
                str += randomLetter();
                System.out.print("\n" + str);
                oldTime = System.currentTimeMillis();
                currentTime = 0;
                while (currentTime - oldTime < 2000) {
                    currentTime = System.currentTimeMillis();
                }
                for (int i = 0; i < round; i++) {
                    System.out.print("\b \b");
                }
                input = sc.nextLine();
                round++;
            }
            System.out.println("\nPlay again? {y/n}");
            String choice = sc.nextLine();
            if (!choice.toUpperCase().equals("Y")) {
                break;
            }
            input = "";
            str = "";
            System.out.println("\nGet Ready to Start!");
        }
        sc.close();
    }
}
