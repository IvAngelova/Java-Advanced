package T1StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = scan.nextInt();
        int x = scan.nextInt();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        //n на брой пъти добавяме
        for (int i = 0; i < n; i++) {
            queue.offer(scan.nextInt());
        }
        //s на брой пъти pop
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
