package T1StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] children = scan.nextLine().split("\\s+");
        int tossesToRemoveOn = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String child : children) {
            queue.offer(child);
        }
        int currentRound = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < tossesToRemoveOn; i++) {
                String currentChild = queue.remove();
                queue.offer(currentChild);
            }

            String name = queue.peek();
            if (isPrime(currentRound)) {
                System.out.println("Prime " + name);
            } else {
                System.out.println("Removed " + name);
                queue.poll();
            }
            currentRound++;
        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
