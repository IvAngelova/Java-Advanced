package T2MultidimensionalsArrays.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rotation = scan.nextLine();
        //изчисляваме ъгъла като делим остъчно на 360 градуса
        int angleRotation = Integer.parseInt(rotation.split("[()]")[1]) % 360;

        List<String> linesForMatrix = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;

        String input = scan.nextLine();
        while (!input.equals("END")) {
            linesForMatrix.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            input = scan.nextLine();
        }
        int rows = linesForMatrix.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];

        //fill matrix
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < linesForMatrix.get(row).length()) {
                    matrix[row][col] = linesForMatrix.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        //въртим нашата първоначална матрица без да променяме нищо по нея
        if (angleRotation == 90) {  // колоните стават редове
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angleRotation == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angleRotation == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {  //без промяна
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }


    }
}
