package T2MultidimensionalsArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rowsCols = scan.nextLine().split(", ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] line = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = line;
        }
        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;
        //въртим до редът -1 и колоната -1, защото иначе ще излезнем извън матрицата
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentSum = getSumOf2X2SubMatrixFromTopLeft(matrix, row, col);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.printf("%d %d\n%d %d\n%d", matrix[maxRow][maxCol], matrix[maxRow][maxCol + 1],
                matrix[maxRow + 1][maxCol],
                matrix[maxRow + 1][maxCol + 1],
                maxSum);
    }

    private static int getSumOf2X2SubMatrixFromTopLeft(int[][] matrix, int row, int col) {
        return matrix[row][col] + matrix[row][col + 1]
                + matrix[row + 1][col] + matrix[row + 1][col + 1];
    }
}
