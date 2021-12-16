package T3SetsAndMaps.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countCompounds = Integer.parseInt(scan.nextLine());
        TreeSet<String> elements = new TreeSet<>();
        for (int i = 0; i < countCompounds; i++) {
            String[] compounds = scan.nextLine().split("\\s+");
//            for (String element : compounds) {
//                elements.add(element);
//            }

            // Collections.addAll(elements, compounds);

            elements.addAll(Arrays.asList(compounds));
        }
        System.out.println(String.join(" ", elements));
    }
}
