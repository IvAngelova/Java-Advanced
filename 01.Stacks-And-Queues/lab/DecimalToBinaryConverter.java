package T1StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int decimalNumber = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (decimalNumber == 0) {
            System.out.println(0);
        } else {
            while (decimalNumber > 0) {
                int reminder = decimalNumber % 2;
                stack.push(reminder);
                decimalNumber = decimalNumber / 2;
            }
        }
        for (Integer reminder : stack) {
            System.out.print(reminder);
        }
    }
}
