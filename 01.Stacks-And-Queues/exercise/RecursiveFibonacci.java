package T1StacksAndQueues.exercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memoryForFib;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        memoryForFib = new long[n + 1];
        System.out.println(fib(n));
    }

    public static long fib(int n) {
        if (n <= 1) {
            //дъно на рекурсията
            return 1;
        }
        if (memoryForFib[n] != 0) {
            //вече е изчислено
            return memoryForFib[n];
        }
        return memoryForFib[n] = fib(n - 1) + fib(n - 2);
    }
}
