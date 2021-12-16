package ExamPrep;

import java.util.Scanner;

public class Bee_02 {
    static int rowBee = 0, colBee = 0, countFlowers = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];
        fillMatrix(scan, size, matrix);

        boolean isBeeLost = false;
        String command = scan.nextLine();

        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    isBeeLost = moveBee(matrix, -1, 0);
                    break;
                case "down":
                    isBeeLost = moveBee(matrix, +1, 0);
                    break;
                case "left":
                    isBeeLost = moveBee(matrix, 0, -1);
                    break;
                case "right":
                    isBeeLost = moveBee(matrix, 0, +1);
                    break;
            }
            if (isBeeLost) {
                break;
            }
            command = scan.nextLine();
        }

        if (isBeeLost) {
            System.out.println("The bee got lost!");
        }
        if (countFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - countFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", countFlowers);
        }
        System.out.println(getMatrixString(matrix));
    }

    private static boolean moveBee(char[][] matrix, int rowAddition, int colAddition) {
        matrix[rowBee][colBee] = '.';
        if (isInBounds(matrix, rowBee + rowAddition, colBee + colAddition)) {
            if (matrix[rowBee + rowAddition][colBee + colAddition] == 'f') {
                countFlowers++;
                rowBee += rowAddition;
                colBee += colAddition;
            } else if (matrix[rowBee + rowAddition][colBee + colAddition] == 'O') {
                matrix[rowBee + rowAddition][colBee + colAddition] = '.';
                rowBee += (2 * rowAddition);
                colBee += (2 * colAddition);
                if (matrix[rowBee][colBee] == 'f') {
                    countFlowers++;
                }
            } else if (matrix[rowBee + rowAddition][colBee + colAddition] == '.') {
                rowBee += rowAddition;
                colBee += colAddition;
            }

            matrix[rowBee][colBee] = 'B';
            return false;
        } else {
            //outOfBounds
            return true;
        }
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }


    private static String getMatrixString(char[][] matrix) {
        StringBuilder out = new StringBuilder();
        for (char[] row : matrix) {
            for (char element : row) {
                out.append(element);
            }
            out.append(System.lineSeparator());
        }

        return out.toString();
    }

    private static void fillMatrix(Scanner scan, int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            String line = scan.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("B")) {
                rowBee = row;
                colBee = line.indexOf('B');
            }
        }
    }
}
