package T3SetsAndMaps.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        LinkedHashSet<String> uniqueUsernames = new LinkedHashSet<>();
        while (n-- > 0) {
            String username = scan.nextLine();
            uniqueUsernames.add(username);
        }
        for (String username : uniqueUsernames) {
            System.out.println(username);
        }
        //System.out.println(String.join(System.lineSeparator(), uniqueUsernames));
        //uniqueUsernames.forEach(System.out::println);
    }
}
