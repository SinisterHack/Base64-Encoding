# Base64-Encoding
### Java Code:

```java
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
```

### Aim of the Code:

The aim of this code is to **read a list of passwords from a file, encode each password using Base64 encoding, and write the encoded passwords to a new file**. This helps in obfuscating the passwords for secure storage or transmission.

### Detailed Explanation of Each Syntax:

1. **Imports**:
    ```java
    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Base64;
    ```
    These import statements bring in the necessary Java classes for file handling and Base64 encoding.

2. **Class and Main Method Definition**:
    ```java
    public class EncodePasswords {
        public static void main(String[] args) {
    ```
    This defines the `EncodePasswords` class and the `main` method, which is the entry point of the program.

3. **Try-with-Resources Statement**:
    ```java
    try (BufferedReader file1 = new BufferedReader(new FileReader("pwd.lst"));
         BufferedWriter file2 = new BufferedWriter(new FileWriter("b64pwds.lst"))) {
    ```
    This block opens `pwd.lst` for reading and `b64pwds.lst` for writing. The try-with-resources statement ensures that both files are closed automatically after the block is executed.

4. **Reading Lines from the File**:
    ```java
    String line;
    while ((line = file1.readLine()) != null) {
    ```
    This loop reads each line from `pwd.lst` until the end of the file is reached.

5. **Processing Each Line**:
    ```java
    String clear = "administrator:" + line.strip();
    ```
    This concatenates "administrator:" with the stripped password from the current line.

6. **Base64 Encoding**:
    ```java
    String encoded = Base64.getEncoder().encodeToString(clear.getBytes());
    ```
    This encodes the concatenated string using Base64 encoding.

7. **Writing to the Output File**:
    ```java
    file2.write(encoded + "\n");
    ```
    This writes the encoded string to `b64pwds.lst`, followed by a newline character.

8. **Exception Handling**:
    ```java
    } catch (IOException e) {
        e.printStackTrace();
    }
    ```
    This block catches and prints any `IOException` that occurs during file operations.

### Use of the Code:

1. **Password Management**:
   - **Secure Storage**: Encoding passwords using Base64 before storing them in files can provide a basic level of security by obfuscating the actual passwords.
   - **Data Transmission**: Encoded passwords can be safely transmitted over networks, reducing the risk of exposure during transmission.

2. **Data Obfuscation**:
   - **Basic Obfuscation**: While Base64 encoding is not encryption, it can be used to obscure data, making it less readable and less likely to be directly exploited if exposed.

3. **Automation**:
   - **Batch Processing**: This code can be used to automate the process of encoding multiple passwords, making it efficient for handling large datasets.

By using this code, you can ensure that passwords are not stored in plaintext, adding a layer of security to your password management process.
