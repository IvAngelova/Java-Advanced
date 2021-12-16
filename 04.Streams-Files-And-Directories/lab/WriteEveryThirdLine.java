package T4StreamsFilesAndDirectories.lab;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String pathInput = "C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput = "05.WriteEveryThirdLine.txt";
        try (FileReader inputReader = new FileReader(pathInput);
             FileWriter output = new FileWriter(pathOutput)) {

            BufferedReader reader = new BufferedReader(inputReader);
            PrintWriter writer = new PrintWriter(output);

            int counter = 1;
            String line = reader.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    writer.println(line);
                }
                counter++;
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
