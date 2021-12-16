package T2MultidimensionalsArrays.lab;

import java.util.*;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            int[] line = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = line;
        }
        String[] coordinates = scan.nextLine().split(" ");
        int wrongValue = matrix[Integer.parseInt(coordinates[0])][Integer.parseInt(coordinates[1])];

        List<int[]> updatedValues = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    updatedValues.add(new int[]{row, col, getSum(matrix, row, col, wrongValue)});
                }
            }
        }
        for (int[] updatedValue : updatedValues) {
            matrix[updatedValue[0]][updatedValue[1]] = updatedValue[2];
        }

        //print the updated matrix
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }


    }

    private static int getSum(int[][] inputMatrix, int row, int col, int wrongValue) {
        int sum = 0;
        //up
        if (row - 1 >= 0 && inputMatrix[row - 1][col] != wrongValue) {
            sum += inputMatrix[row - 1][col];
        }
        //down
        if (row + 1 < inputMatrix.length && inputMatrix[row + 1][col] != wrongValue) {
            sum += inputMatrix[row + 1][col];
        }
        //right
        if (col + 1 < inputMatrix[row].length && inputMatrix[row][col + 1] != wrongValue) {
            sum += inputMatrix[row][col + 1];
        }
        //left
        if (col - 1 >= 0 && inputMatrix[row][col - 1] != wrongValue) {
            sum += inputMatrix[row][col - 1];
        }
        return sum;
    }
}
