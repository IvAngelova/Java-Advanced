package T5FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(name -> name.length() <= n)
                .forEach(System.out::println);
    }
}
