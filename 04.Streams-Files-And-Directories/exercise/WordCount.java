package T4StreamsFilesAndDirectories.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");
        Path pathSearch = Path.of("C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        try {
            List<String> lines = Files.readAllLines(path);

            Map<String, Integer> wordsCount = new HashMap<>();

            for (String line : lines) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordsCount.put(word, 0);
                }
            }
            List<String> searchedLines = Files.readAllLines(pathSearch);

            for (String line : searchedLines) {
                String[] words = line.split("[\\s+.,]");
                for (String word : words) {
                    if (wordsCount.containsKey(word)) {
                        wordsCount.put(word, wordsCount.get(word) + 1);
                    }
                }
            }


            PrintWriter writer = new PrintWriter("WordCount.txt");
            // BufferedWriter writer = new BufferedWriter(new FileWriter("allCapitals.txt"));
            wordsCount.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e -> writer.println(e.getKey() + " - " + e.getValue()));

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
