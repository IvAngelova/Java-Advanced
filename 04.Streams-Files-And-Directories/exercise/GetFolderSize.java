package T4StreamsFilesAndDirectories.exercise;

import java.io.File;


public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);

        int folderSize = 0;
        File[] files = folder.listFiles();
        for (File file : files) {
           folderSize += file.length();
        }
        System.out.println("Folder size: " + folderSize);
    }
}
