package T1StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int index = 0; index < expression.length(); index++) {
            char currentSymbol = expression.charAt(index);
            if (currentSymbol == '(') {
                stack.push(index);
            } else if (currentSymbol == ')') {
                int startIndex = stack.pop();
                String contents = expression.substring(startIndex, index + 1);
                System.out.println(contents);
            }
        }

    }
}
