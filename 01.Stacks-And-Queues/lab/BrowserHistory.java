package T1StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        String currentURL = "";
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (browserHistory.isEmpty() || browserHistory.size() == 1) {
                    System.out.println("no previous URLs");
                    command = scan.nextLine();
                    continue;
                } else {
                    browserHistory.pop();
                    currentURL = browserHistory.peek();
                }
            } else {
                currentURL = command;
                browserHistory.push(currentURL);
            }

            System.out.println(currentURL);
            command = scan.nextLine();
        }
    }
}
