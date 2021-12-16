package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp_01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stackMales = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(e -> e > 0)
                .forEach(stackMales::push);
        ArrayDeque<Integer> queueFemales = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(e -> e > 0)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;

        while (!stackMales.isEmpty() && !queueFemales.isEmpty()) {
            int firstFemale = queueFemales.peek();
            int lastMale = stackMales.peek();

            if (firstFemale <= 0) {
                queueFemales.poll();
                continue;
            }
            if (lastMale <= 0) {
                stackMales.pop();
                continue;
            }
            if (firstFemale % 25 == 0) {
                queueFemales.poll();
                queueFemales.poll();
                continue;
            }
            if (lastMale % 25 == 0) {
                stackMales.pop();
                stackMales.pop();
                continue;
            }


            queueFemales.poll();
            stackMales.pop();

            if (firstFemale == lastMale) {
                matches++;
            } else {
                lastMale -= 2;
                stackMales.push(lastMale);
            }

        }
        System.out.println("Matches: " + matches);
        if (stackMales.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(stackMales.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (queueFemales.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(queueFemales.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }


    }
}
