package T2MultidimensionalsArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        char[][] firstMatrix = readMatrix(scan, rows, cols);
        char[][] secondMatrix = readMatrix(scan, rows, cols);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.print("* ");
                } else {
                    System.out.print(firstMatrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner scan, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = (scan.nextLine().split(" "));
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col].charAt(0);
            }
        }
        return matrix;
    }
}
