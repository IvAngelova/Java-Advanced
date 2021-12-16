package T5FunctionalProgramming.lab;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lower = scan.nextInt();
        int upper = scan.nextInt();
        scan.nextLine();
        String oddOrEven = scan.nextLine();

        Predicate<Integer> filter = filter(oddOrEven);

        Consumer<Integer> printer = x-> System.out.print(x + " ");

        IntStream
                .rangeClosed(lower, upper)
                .boxed()
                .filter(filter)
                .forEach(printer);
    }

    private static Predicate<Integer> filter(String oddOrEven) {
        if (oddOrEven.equals("odd")) {
            return x -> x % 2 != 0;
        }
        return x -> x % 2 == 0;
    }
}
