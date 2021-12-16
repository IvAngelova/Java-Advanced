package T4StreamsFilesAndDirectories.lab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try (FileInputStream inputStream = new FileInputStream(path)) {
            int oneByte = inputStream.read(); //чете символ по символ като числова репрезентация на аски кода
            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
