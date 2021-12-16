package T9IteratorsAndComparators.exercise.Froggy_04;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        String command = scan.nextLine();
        Lake lake = new Lake(numbers);
        StringBuilder output = new StringBuilder();
        if (command.equals("END")) {
            for (Integer integer : lake) {
                output.append(integer).append(", ");
            }
        }
        System.out.println(output.toString().substring(0, output.lastIndexOf(",")));
    }
}
