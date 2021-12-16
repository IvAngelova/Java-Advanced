package ExamPrep;

import java.util.Scanner;

public class Python_02 {
    static int snakeRow = 0, snakeCol = 0, totalFoodToBeEaten = 0, snakeLength = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(", ");
        char[][] matrix = new char[size][size];
        fillMatrix(scan, size, matrix);

        boolean isKilledByEnemy = false;

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            switch (currentCommand) {
                case "up":
                    isKilledByEnemy = moveSnake(matrix, -1, 0);
                    break;
                case "down":
                    isKilledByEnemy = moveSnake(matrix, +1, 0);
                    break;
                case "right":
                    isKilledByEnemy = moveSnake(matrix, 0, +1);
                    break;
                case "left":
                    isKilledByEnemy = moveSnake(matrix, 0, -1);
                    break;

            }
            if (isKilledByEnemy) {
                break;
            }
            if (totalFoodToBeEaten == 0) {
                break;
            }
        }


        if (isKilledByEnemy) {
            System.out.println("You lose! Killed by an enemy!");
        }

        if (totalFoodToBeEaten == 0) {
            System.out.println("You win! Final python length is " + snakeLength);
        } else if (totalFoodToBeEaten > 0 && !isKilledByEnemy) {
            System.out.printf("You lose! There is still %d food to be eaten.", totalFoodToBeEaten);
        }


    }

    private static boolean moveSnake(char[][] matrix, int rowAddition, int colAddition) {

        snakeRow = setRowsAndColsInBounds(snakeRow + rowAddition, matrix.length);
        snakeCol = setRowsAndColsInBounds(snakeCol + colAddition, matrix.length);

        if (matrix[snakeRow][snakeCol] == 'f') {
            snakeLength += 1;
            totalFoodToBeEaten--;
            matrix[snakeRow][snakeCol] = '*';
        } else if (matrix[snakeRow][snakeCol] == 'e') {
            return true;
        }

        return false;
    }

    private static int setRowsAndColsInBounds(int value, int size) {

        if (value < 0) {
            value = size - 1;
        }
        if (value >= size) {
            value = 0;
        }
        return value;
    }

    private static void fillMatrix(Scanner scan, int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line[col].charAt(0);
                if (matrix[row][col] == 's') {
                    snakeRow = row;
                    snakeCol = col;
                }
                if (matrix[row][col] == 'f') {
                    totalFoodToBeEaten++;
                }
            }
        }
    }
}
