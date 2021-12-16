package T4StreamsFilesAndDirectories.exercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DemoCreateFilesInDesktopFolder {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 100; i++) {
            File file = new File("C:\\Users\\I353529\\Desktop\\100_files\\file_" + i + ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(file.getName());
            writer.write("\n");
            writer.write(file.getPath());
            writer.close();
        }
    }
}
