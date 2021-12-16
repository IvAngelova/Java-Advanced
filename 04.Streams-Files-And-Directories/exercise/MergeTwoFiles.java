package T4StreamsFilesAndDirectories.exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) {
        Path path1 = Path.of("C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path path2 = Path.of("C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");

        try {
            List<String> lines1 = Files.readAllLines(path1);
            List<String> lines2 = Files.readAllLines(path2);
            PrintWriter writer = new PrintWriter("MergeTwoFiles.txt");

            lines1.forEach(line-> writer.println(line));
            lines2.forEach(writer::println);

            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
