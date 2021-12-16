package T5FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(", ");
        Function<String[], Stream<Integer>> map = arr -> Arrays.stream(arr).map(Integer::parseInt);
        Function<Stream<Integer>, Integer> sum = stream -> stream.mapToInt(x -> x).sum();
        Function<Stream<Integer>, Long> count = str -> str.mapToInt(x -> x).count();

        System.out.println("Count = " + count.apply(map.apply(tokens)));
        System.out.println("Sum = " + sum.apply(map.apply(tokens)));
    }
}
