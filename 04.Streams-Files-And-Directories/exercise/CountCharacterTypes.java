package T4StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class CountCharacterTypes {
    public static void main(String[] args) {
        String path = "C:\\Users\\Iva\\Desktop\\SoftUni\\03.JavaAdvanced\\JavaAdvanced" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();

            int vowels = 0;
            int consonants = 0;
            int punctuation = 0;
            while (line != null) {
                for (char symbol : line.toCharArray()) {
                    if (symbol == ' ') {
                        continue;
                    }
                    if (isVowel(symbol)) {
                        vowels++;
                    } else if (isPunctuation(symbol)) {
                        punctuation++;
                    } else {
                        consonants++;
                    }
                }
                line = reader.readLine();
            }

            PrintWriter writer = new PrintWriter("CountCharTypes.txt");
            // BufferedWriter writer = new BufferedWriter(new FileWriter("allCapitals.txt"));
            writer.println("Vowels: " + vowels);
            writer.println("Consonants: " + consonants);
            writer.println("Punctuation: " + punctuation);


            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '.' || symbol == ',' || symbol == '!' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'o' || symbol == 'u' || symbol == 'e' || symbol == 'i';
    }
}
