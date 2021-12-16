package T4StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String pathInput = "C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOutput = "04.ExtractIntegers.txt";
        try (FileInputStream inputStream = new FileInputStream(pathInput);
             FileOutputStream outputStream = new FileOutputStream(pathOutput)) {

            Scanner scanner = new Scanner(inputStream);
            PrintStream printStream = new PrintStream(outputStream);

            while (scanner.hasNext()){
                if(scanner.hasNextInt()){
                    int number = scanner.nextInt();
                    printStream.println(number);
                }
                scanner.next();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
