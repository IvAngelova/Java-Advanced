package T1StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] children = scan.nextLine().split("\\s+");
        int tossesToRemoveOn = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
//        for (String child : children) {
//            queue.offer(child);
//        }
        Collections.addAll(queue, children);
        while (queue.size() > 1) {
            for (int i = 1; i < tossesToRemoveOn; i++) {
                String currentChild = queue.poll();
                queue.offer(currentChild);
            }

            String name = queue.poll();
            System.out.println("Removed " + name);
        }

        System.out.println("Last is " + queue.poll());
    }
}
