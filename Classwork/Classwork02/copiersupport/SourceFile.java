package copiersupport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SourceFile {

    private BufferedReader br;
    private String output = "";
    private File file;

    public SourceFile(String fileName) throws IOException {
        file = new File(fileName);
        br = new BufferedReader(new FileReader(file));
    }

    public String readMe() throws IOException {
        String temp = br.readLine();
        while (!(temp.contains("EOF"))) {
            output += temp + "\n";
            temp = br.readLine();
        }

        br.close();

        return output;
    }
}