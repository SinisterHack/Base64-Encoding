import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class EncodePasswords {
    public static void main(String[] args) {
        try (BufferedReader file1 = new BufferedReader(new FileReader("pwd.lst"));
             BufferedWriter file2 = new BufferedWriter(new FileWriter("b64pwds.lst"))) {
            String line;
            while ((line = file1.readLine()) != null) {
                String clear = "administrator:" + line.strip();
                String encoded = Base64.getEncoder().encodeToString(clear.getBytes());
                file2.write(encoded + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
