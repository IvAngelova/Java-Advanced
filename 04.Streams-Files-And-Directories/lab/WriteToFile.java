package T4StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WriteToFile {
    public static void main(String[] args) {
        String pathInput = "C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput = "02.WriteToFile.txt";
        try (FileInputStream inputStream = new FileInputStream(pathInput);
             FileOutputStream outputStream = new FileOutputStream(pathOutput)) {

            HashSet<Character> punctuation = new HashSet<>(Arrays.asList(',', '.', '!', '?'));
            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char) oneByte)) {
                    outputStream.write((char)oneByte);
                }
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
