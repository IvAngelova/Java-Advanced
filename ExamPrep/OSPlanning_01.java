package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlanning_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] tasks = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[] threads = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int taskToBeKilled = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> stackTasks = new ArrayDeque<>(); //LIFO
        for (int i = 0; i < tasks.length; i++) {
            stackTasks.push(tasks[i]);
        }

        ArrayDeque<Integer> queueThreads = new ArrayDeque<>(); //FIFO
        for (int thread : threads) {
            queueThreads.offer(thread);
        }

        while (!stackTasks.isEmpty()) {
            int currentTask = stackTasks.peek();
            int currentThread = queueThreads.peek();
            if (currentTask == taskToBeKilled) {
                System.out.printf("Thread with value %d killed task %d%n",
                        currentThread, currentTask);
                break;
            }
            if (currentThread >= currentTask) {
                stackTasks.pop();
                queueThreads.poll();
            } else {
                queueThreads.poll();
            }
        }

        for (Integer queueThread : queueThreads) {
            System.out.print(queueThread + " ");
        }

    }
}
