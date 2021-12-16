package T4StreamsFilesAndDirectories.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            PrintWriter writer = new PrintWriter("LineNumbers.txt");
            // BufferedWriter writer = new BufferedWriter(new FileWriter("allCapitals.txt"));
            int counterRow = 1;
            for (String line : lines) {
                writer.println(counterRow + ". " + line);
                counterRow++;
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
