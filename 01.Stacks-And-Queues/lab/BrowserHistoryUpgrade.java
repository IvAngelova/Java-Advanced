package T1StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        String currentURL = "";
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();
        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (browserHistory.isEmpty() || browserHistory.size() == 1) {
                    System.out.println("no previous URLs");
                    command = scan.nextLine();
                    continue;
                } else {
                    String URLToRemove = browserHistory.pop();
                    forwardStack.push(URLToRemove);
                    currentURL = browserHistory.peek();
                }
            } else if (command.equals("forward")) {
                if (forwardStack.isEmpty()) {
                    System.out.println("no next URLs");
                    command = scan.nextLine();
                    continue;
                } else {
                    String URLToForward = forwardStack.pop();
                    browserHistory.push(URLToForward);
                    currentURL = browserHistory.peek();
                }
            } else {
                currentURL = command;
                browserHistory.push(currentURL);
                forwardStack.clear();
            }

            System.out.println(currentURL);
            command = scan.nextLine();
        }
    }
}
