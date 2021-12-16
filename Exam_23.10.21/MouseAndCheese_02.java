package Exam;

import java.util.Scanner;

public class MouseAndCheese_02 {
    public static int mouseRow = 0, mouseCol = 0, cheeseEaten = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];
        fillMatrix(scan, matrix, size);
        boolean isOutOfMatrix = false;

        String command = scan.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    isOutOfMatrix = moveMouse(matrix, -1, 0);
                    break;
                case "down":
                    isOutOfMatrix = moveMouse(matrix, +1, 0);
                    break;
                case "left":
                    isOutOfMatrix = moveMouse(matrix, 0, -1);
                    break;
                case "right":
                    isOutOfMatrix = moveMouse(matrix, 0, +1);
                    break;
            }

            if (isOutOfMatrix) {
                break;
            }
            command = scan.nextLine();
        }


        if (isOutOfMatrix) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseEaten >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        }

        printMatrix(matrix);
    }

    private static boolean moveMouse(char[][] matrix, int rowAddition, int colAddition) {
        boolean isOut = false;
        matrix[mouseRow][mouseCol] = '-';
        int newRow = mouseRow + rowAddition;
        int newCol = mouseCol + colAddition;
        if (isInBounds(matrix, newRow, newCol)) {
            if (matrix[newRow][newCol] == 'B') {
                matrix[newRow][newCol] = '-';
                newRow += rowAddition;
                newCol += colAddition;
            }
            if (matrix[newRow][newCol] == 'c') {
                cheeseEaten += 1;
            }
            mouseRow = newRow;
            mouseCol = newCol;
            matrix[mouseRow][mouseCol] = 'M';
        } else {
            isOut = true;
        }
        return isOut;
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scan, char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            String line = scan.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("M")) {
                mouseRow = row;
                mouseCol = line.indexOf("M");
            }
        }
    }
}
