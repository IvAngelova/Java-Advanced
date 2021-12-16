package T4StreamsFilesAndDirectories.lab;

import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {
        File fileRoot = new File("C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced" +
                "\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        ArrayDeque<File> files = new ArrayDeque<>();
        files.offer(fileRoot);

        int counter = 1;
        while (!files.isEmpty()) {
            File innerFile = files.poll();
            System.out.println(innerFile.getName());
            for (File f : innerFile.listFiles()) {
                if (f.isDirectory()) {
                    files.offer(f);
                    counter++;
                }
            }

        }
        System.out.println(counter + " folders");
    }
}
