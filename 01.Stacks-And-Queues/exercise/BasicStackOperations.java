package T1StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = scan.nextInt();
        int x = scan.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //n на брой пъти добавяме
        for (int i = 0; i < n; i++) {
            stack.push(scan.nextInt());
        }
        //s на брой пъти pop
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stack));
            }
        }

    }
}
