package T5FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findMinElement = list -> {
            int min = Integer.MAX_VALUE;
            for (Integer integer : list) {
                if (integer < min) {
                    min = integer;
                }
            }
            return min;
        };

        int min = findMinElement.apply(numbers);
        System.out.println(numbers.lastIndexOf(min));
    }
}
