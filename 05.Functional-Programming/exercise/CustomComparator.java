package T5FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //първо четно, второ нечетно -> -1 (първо, второ)
        //първо нечетно, второ четно -> 1 (второ, първо)
        //първо четно, второ четно -> първо > второ (1), първо < второ (-1)
        //първо нечетно, второ нечетно -> първо > второ (1), първо < второ (-1)

        Comparator<Integer> comparator = (firstNumber, secondNumber) -> {
            if (firstNumber % 2 == 0 && secondNumber % 2 != 0) {
                return -1;
            } else if (firstNumber % 2 != 0 && secondNumber % 2 == 0) {
                return 1;
            } else if (firstNumber % 2 == 0 && secondNumber % 2 == 0) {
                if (firstNumber <= secondNumber) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (firstNumber % 2 != 0 && secondNumber % 2 != 0) {
                if (firstNumber <= secondNumber) {
                    return -1;
                } else {
                    return 1;
                }
            }

            return 0;
        };

        numbers.sort(comparator);
        numbers.forEach(n-> System.out.print(n + " "));

    }
}
