package T2MultidimensionalsArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rowsCols = scan.nextLine().split(", ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);
        int sumAllElements = 0;
        for (int row = 0; row < rows; row++) {
            sumAllElements += Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).sum();
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sumAllElements);
    }
}
