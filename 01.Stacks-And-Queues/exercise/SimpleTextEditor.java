package T1StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfOperations = Integer.parseInt(scan.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> memoryStack = new ArrayDeque<>();
        for (int i = 0; i < countOfOperations; i++) {
            String[] command = scan.nextLine().split(" ");
            String typeOfCommand = command[0];
            switch (typeOfCommand) {
                case "1":
                    memoryStack.push(text.toString());
                    String stringToAppend = command[1];
                    text.append(stringToAppend);
                    break;
                case "2":
                    memoryStack.push(text.toString());
                    int count = Integer.parseInt(command[1]);
                    text.delete(text.length() - count, text.length());
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    if (!memoryStack.isEmpty()) {
                        text = new StringBuilder(memoryStack.pop());
                    }
                    break;
            }
        }
    }
}
