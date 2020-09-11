import java.io.IOException;
import java.util.Scanner;

import copiersupport.*;

public class MyFileCopier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter File Name To Copy:");

        String fileName = input.nextLine();

        input.close();

        try {
            SourceFile source = new SourceFile(fileName);
            String sourceText = source.readMe();
            TargetFile target = new TargetFile(fileName);
            target.writeMe(sourceText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}