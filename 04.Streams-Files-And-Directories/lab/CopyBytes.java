package T4StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class CopyBytes {
    public static void main(String[] args) {
        String pathInput = "C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput = "03.CopyBytes.txt";
        try (FileInputStream inputStream = new FileInputStream(pathInput);
             FileOutputStream outputStream = new FileOutputStream(pathOutput)) {

            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                if (oneByte == ' ' || oneByte == '\n') {
                   outputStream.write((char) oneByte);
                } else {
                    String digits = String.valueOf(oneByte);

                    for (int i = 0; i < digits.length(); i++) {
                       outputStream.write(digits.charAt(i)); //outputStream.write
                        // печата символ по символ, байт по байт
                    }

                }
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
