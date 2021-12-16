package T2MultidimensionalsArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        int[][] matrix = new int[rows][cols];
        fillMatrix(scan, matrix, rows, cols);

        int row = rows - 1;
        int col = cols - 1;

        while (row >= 0) {

            int currentRow = row;
            int currentCol = col;

            while (currentCol < cols && currentRow >= 0) {
                System.out.print(matrix[currentRow--][currentCol++] + " ");
            }
            System.out.println();
            col--;

            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }

    private static void fillMatrix(Scanner scan, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            int[] line = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = line;
        }
    }
}
