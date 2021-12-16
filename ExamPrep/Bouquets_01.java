package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] tulips = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[] daffodils = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stackTulips = new ArrayDeque<>();
        for (int tulip : tulips) {
            stackTulips.push(tulip);
        }
        ArrayDeque<Integer> queueDaffodils = new ArrayDeque<>();
        for (int daffodil : daffodils) {
            queueDaffodils.offer(daffodil);
        }

        int extraStoredFlowers = 0;
        int countBouquets = 0;

        while (!stackTulips.isEmpty() && !queueDaffodils.isEmpty()) {
            int currentTulip = stackTulips.peek();
            int currentDaffodil = queueDaffodils.peek();
            if (currentDaffodil + currentTulip == 15) {
                countBouquets++;
            } else if (currentDaffodil + currentTulip > 15) {
                while (currentDaffodil + currentTulip > 15) {
                    currentTulip -= 2;
                }
                if (currentDaffodil + currentTulip == 15) {
                    countBouquets++;
                }
                if (currentDaffodil + currentTulip < 15) {
                    extraStoredFlowers += (currentDaffodil + currentTulip);
                }
            } else if (currentDaffodil + currentTulip < 15) {
                extraStoredFlowers += (currentDaffodil + currentTulip);
            }

            stackTulips.pop();
            queueDaffodils.poll();

        }

        int extraBouquets = extraStoredFlowers / 15;
        countBouquets += extraBouquets;

        if (countBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!",
                    countBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - countBouquets);
        }
    }
}

