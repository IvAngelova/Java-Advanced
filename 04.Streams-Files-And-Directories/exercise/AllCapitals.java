package T4StreamsFilesAndDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            PrintWriter writer = new PrintWriter("allCapitals.txt");
         // BufferedWriter writer = new BufferedWriter(new FileWriter("allCapitals.txt"));
            for (String line : lines) {
                writer.println(line.toUpperCase());
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
