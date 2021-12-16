package T4StreamsFilesAndDirectories.lab;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("red", 13, 42, 69);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cube.ser"));
        oos.writeObject(cube);
        oos.close();

        //deserialization
        ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream("cube.ser"));
        Cube cubeSaved = (Cube) objInputStream.readObject();
        System.out.println(cubeSaved.color);
        objInputStream.close();
    }

    public static class Cube implements Serializable {
        private String color;
        private int width;
        private int length;
        private int height;

        public Cube(String color, int width, int length, int height) {
            this.color = color;
            this.width = width;
            this.length = length;
            this.height = height;
        }
    }
}
