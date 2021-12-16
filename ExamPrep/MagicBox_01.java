package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] firstBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] secondBox = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stackSecondBox = new ArrayDeque<>();
        for (int item : secondBox) {
            stackSecondBox.push(item);
        }
        ArrayDeque<Integer> queueFirstBox = new ArrayDeque<>();
        for (int item : firstBox) {
            queueFirstBox.offer(item);
        }

        int sumOfClaimedItems = 0;

        while (!stackSecondBox.isEmpty() && !queueFirstBox.isEmpty()) {
            int firstItem = queueFirstBox.peek();
            int lastItem = stackSecondBox.pop();
            if ((firstItem + lastItem) % 2 == 0) {
                sumOfClaimedItems += (firstItem + lastItem);
                queueFirstBox.poll();
            } else {
                queueFirstBox.offer(lastItem);
            }
        }

        if (queueFirstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        if (sumOfClaimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + sumOfClaimedItems);
        } else {
            System.out.println("Poor prey... Value: " + sumOfClaimedItems);
        }
    }
}
