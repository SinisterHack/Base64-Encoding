# Base64 Encoding

## Description

This project is a simple Base64 Encoder implemented in Java. It reads a list of passwords from a file, encodes them in Base64, and writes the encoded passwords to a new file.

## Features

- Reads passwords from a file.
- Encodes each password in Base64 format.
- Writes the encoded passwords to a new file.

## Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/base64-encoding.git
   cd base64-encoding
   ```

2. Compile the Java code:
   ```bash
   javac EncodePasswords.java
   ```

3. Run the Base64 Encoder:
   ```bash
   java EncodePasswords <input_file> <output_file>
   ```
   Replace `<input_file>` with the path to the file containing the passwords and `<output_file>` with the path to the file where you want to save the encoded passwords.

## Example

To encode passwords from `pwd.lst` and save the encoded passwords to `b64pwds.lst`:
```bash
java EncodePasswords pwd.lst b64pwds.lst
```

## Code Explanation

- **EncodePasswords.java**:
  - **Imports necessary packages**:
    ```java
    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Base64;
    ```
  - **Main class and method**:
    ```java
    public class EncodePasswords {
        public static void main(String[] args) {
            if (args.length != 2) {
                System.out.println("Usage: java EncodePasswords <input_file> <output_file>");
                return;
            }

            String inputFile = args[0];
            String outputFile = args[1];

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                 
                String line;
                while ((line = reader.readLine()) != null) {
                    String clear = "administrator:" + line.trim();
                    String encoded = Base64.getEncoder().encodeToString(clear.getBytes());
                    writer.write(encoded);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    ```

## Dependencies

- Java Development Kit (JDK)

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the [MIT License](./LICENSE.txt).
