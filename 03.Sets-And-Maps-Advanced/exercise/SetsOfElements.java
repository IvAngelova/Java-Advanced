package T3SetsAndMaps.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();
        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();
        for (int count = 0; count < n; count++) {
            int num = Integer.parseInt(scan.nextLine());
            firstSet.add(num);
        }
        for (int count = 0; count < m; count++) {
            int num = Integer.parseInt(scan.nextLine());
            secondSet.add(num);
        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
