package ExamPrep;

import java.util.Scanner;

public class Snake_02 {
    public static int snakeRow = 0, snakeCol = 0, foodEaten = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];
        fillMatrix(scan, matrix, size);

        boolean isInBounds = true;

        while (isInBounds && foodEaten < 10) {
            String command = scan.nextLine();
            switch (command) {
                case "up":
                    isInBounds = moveSnake(matrix, -1, 0);
                    break;
                case "down":
                    isInBounds = moveSnake(matrix, +1, 0);
                    break;
                case "left":
                    isInBounds = moveSnake(matrix, 0, -1);
                    break;
                case "right":
                    isInBounds = moveSnake(matrix, 0, +1);
                    break;
            }
        }

        if (!isInBounds) {
            System.out.println("Game over!");
        }
        if (foodEaten >= 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodEaten);

        printMatrix(matrix);

    }

    private static boolean moveSnake(char[][] matrix, int rowAddition, int colAddition) {

        matrix[snakeRow][snakeCol] = '.';

        if (isInBounds(matrix, snakeRow + rowAddition, snakeCol + colAddition)) {

            if (matrix[snakeRow + rowAddition][snakeCol + colAddition] == '*') {
                foodEaten += 1;
            } else if (matrix[snakeRow + rowAddition][snakeCol + colAddition] == 'B') {
                matrix[snakeRow + rowAddition][snakeCol + colAddition] = '.';
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        if (matrix[row][col] == 'B') {
                            snakeRow = row;
                            snakeCol = col;
                            matrix[row][col] = 'S';
                            return true;
                        }
                    }
                }
            }

            snakeRow += rowAddition;
            snakeCol += colAddition;
            matrix[snakeRow][snakeCol] = 'S';

            return true;
        } else {
            return false;
        }
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
            if (line.contains("S")) {
                snakeRow = row;
                snakeCol = line.indexOf("S");
            }
        }
    }
}
