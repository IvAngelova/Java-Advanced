package T1StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                String canceledFile = printerQueue.poll();
                if (canceledFile == null) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + canceledFile);
                }
            } else {
                String fileName = input;
                printerQueue.offer(fileName);
            }

            input = scan.nextLine();
        }
        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
