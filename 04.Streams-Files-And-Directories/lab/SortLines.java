package T4StreamsFilesAndDirectories.lab;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        Path pathInput = Path.of("C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path pathOutput = Paths.get("06.SortLines.txt");
        try (BufferedReader reader = Files.newBufferedReader(pathInput)) {

            List<String> lines = Files.readAllLines(pathInput);
            Collections.sort(lines);

            Files.write(pathOutput, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}