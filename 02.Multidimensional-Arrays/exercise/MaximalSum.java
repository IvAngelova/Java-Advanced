package T2MultidimensionalsArrays.exercise;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dimensions = scan.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(scan, matrix, rows, cols);

        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = getSumOf3X3SubMatrixFromTopLeft(matrix, row, col);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        printSubMatrixAndMaxSum(matrix, maxSum, maxRow, maxCol);
    }

    private static void printSubMatrixAndMaxSum(int[][] matrix, int maxSum, int maxRow, int maxCol) {
        System.out.println("Sum = " + maxSum);
        for (int i = maxRow; i < maxRow + 3; i++) {
            for (int j = maxCol; j < maxCol + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int getSumOf3X3SubMatrixFromTopLeft(int[][] matrix, int row, int col) {
        int sum = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static void fillMatrix(Scanner scan, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            String[] line = scan.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
    }
}
