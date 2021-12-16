package T5FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        BiFunction<int[], Integer, Boolean> predicate = (array, number) -> {
            for (int numInArr : array) {
                if (number % numInArr != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int number = 1; number <= n; number++) {
            if (predicate.apply(numbers, number)) {
                System.out.print(number + " ");
            }

        }
    }

}