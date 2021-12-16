package ExamPrep;

import java.util.Scanner;

public class Bomb_02 {
    static int rowPosition = 0, colPosition = 0, allBombs = 0, countBombs = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(",");
        char[][] matrix = new char[size][size];
        fillMatrix(scan, size, matrix);
        boolean isGameOver = false;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch (command) {
                case "up":
                    isGameOver = moveSapper(matrix, -1, 0);
                    break;
                case "down":
                    isGameOver = moveSapper(matrix, +1, 0);
                    break;
                case "right":
                    isGameOver = moveSapper(matrix, 0, +1);
                    break;
                case "left":
                    isGameOver = moveSapper(matrix, 0, -1);
                    break;
            }

            if (isGameOver) {
                break;
            }
            if (countBombs == allBombs) {
                break;
            }
        }

        if (isGameOver) {
            System.out.printf("END! %d bombs left on the field", allBombs - countBombs);
        } else if (countBombs == allBombs) {
            System.out.println("Congratulations! You found all bombs!");
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", allBombs - countBombs,
                    rowPosition, colPosition);
        }


    }

    private static boolean moveSapper(char[][] matrix, int rowAddition, int colAddition) {

        if (isInBounds(matrix.length, rowPosition + rowAddition, colPosition + colAddition)) {

            if (matrix[rowPosition + rowAddition][colPosition + colAddition] == 'B') {
                countBombs++;
                matrix[rowPosition + rowAddition][colPosition + colAddition] = '+';
                System.out.println("You found a bomb!");
            } else if (matrix[rowPosition + rowAddition][colPosition + colAddition] == 'e') {
                return true;
            }

            rowPosition += rowAddition;
            colPosition += colAddition;
            return false;
        } else {
            return false;
        }
    }

    private static boolean isInBounds(int size, int r, int c) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }

    private static void fillMatrix(Scanner scan, int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line[col].charAt(0);
                if (matrix[row][col] == 's') {
                    rowPosition = row;
                    colPosition = col;
                    matrix[rowPosition][colPosition] = '+';
                }
                if (matrix[row][col] == 'B') {
                    allBombs++;
                }
            }
        }
    }
}
