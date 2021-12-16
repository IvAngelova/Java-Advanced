package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //stack
        ArrayDeque<Integer> lilies = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::push);
        //queue
        ArrayDeque<Integer> roses = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); //add

        int countWreaths = 0;
        int extraStoredFlowers = 0;


        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int firstRose = roses.poll();
            int lastLili = lilies.pop();
            if (firstRose + lastLili == 15) {
                countWreaths++;
            } else if (firstRose + lastLili > 15) {
                while (firstRose + lastLili > 15) {
                    lastLili -= 2;
                }
                if (firstRose + lastLili == 15) {
                    countWreaths++;
                } else if (firstRose + lastLili < 15) {
                    extraStoredFlowers += (firstRose + lastLili);
                }

            } else if (firstRose + lastLili < 15) {
                extraStoredFlowers += (firstRose + lastLili);
            }

        }

        countWreaths += (extraStoredFlowers / 15);
        if (countWreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", countWreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - countWreaths);
        }

    }
}
