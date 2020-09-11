package copiersupport;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class TargetFile {

    private BufferedWriter bw;

    public TargetFile(String sourceName) throws IOException {
        String fileName = sourceName + ".copy";
        bw = new BufferedWriter(new FileWriter(fileName));
    }

    public void writeMe(String input) throws IOException {
        bw.write(input);
        bw.close();
    }
}