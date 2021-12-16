package T4StreamsFilesAndDirectories.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumBytes {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            int sumAllLines = 0;
            for (String line : lines) {
                for (char symbol : line.toCharArray()) {
                    sumAllLines += symbol;
                }
            }
            System.out.println(sumAllLines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
