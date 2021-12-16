package T2MultidimensionalsArrays.exercise;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][size];
        fillMatrix(scan, matrix, size);
        int sumOfPrimaryDiagonal = getSumPrimary(matrix, size);
        int sumOfSecondaryDiagonal = getSumSecondary(matrix, size);
        System.out.println(Math.abs(sumOfPrimaryDiagonal - sumOfSecondaryDiagonal));
    }

    private static int getSumSecondary(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][size - 1 - i];
        }
        return sum;
    }

    private static int getSumPrimary(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static void fillMatrix(Scanner scan, int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            String[] line = scan.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
    }
}
