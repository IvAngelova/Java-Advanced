package T3SetsAndMaps.exercise;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        HashMap<String, String> phonebook = new HashMap<>();
        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            phonebook.put(name, number);
            input = scan.nextLine();
        }
        String searchName = scan.nextLine();
        while (!searchName.equals("stop")) {
            if (phonebook.containsKey(searchName)) {
                System.out.println(searchName + " -> " + phonebook.get(searchName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchName);
            }

            searchName = scan.nextLine();
        }
    }
}
