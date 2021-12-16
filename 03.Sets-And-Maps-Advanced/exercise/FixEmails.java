package T3SetsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, String> emailsData = new LinkedHashMap<>();
        String name = scan.nextLine();
        while (!name.equals("stop")) {
            String email = scan.nextLine();
            if (!email.endsWith("uk") && !email.endsWith("us") && !email.endsWith("com")) {
                emailsData.put(name, email);
            }
            name = scan.nextLine();
        }
        emailsData.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
