package T1StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfCommands = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < countOfCommands; i++) {
            String command = scan.nextLine();
            if (command.equals("2")) {
                stack.pop();
            } else if (command.equals("3")) {
                if (!stack.isEmpty()) {
                    System.out.println(Collections.max(stack));
                    // System.out.println(getMaxElementFromStack(stack));
                }
            } else {
                int elementToPush = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(elementToPush);
            }
        }
    }

//    private static int getMaxElementFromStack(ArrayDeque<Integer> stack) {
//        int max = Integer.MIN_VALUE;
//        while (!stack.isEmpty()) {
//            int currentElement = stack.pop();
//            if (currentElement > max) {
//                max = currentElement;
//            }
//        }
//        return max;
//    }
}
