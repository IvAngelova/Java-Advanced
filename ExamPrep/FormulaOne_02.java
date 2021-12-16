package ExamPrep;

import java.util.Scanner;

public class FormulaOne_02 {
    static int playerRow = 0, playerCol = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int countCommands = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];
        fillMatrix(scan, matrix);

        boolean isWon = false;

        for (int i = 0; i < countCommands; i++) {
            String command = scan.nextLine();
            if (command.equals("up")) {
                isWon = movePlayer(matrix, -1, 0);
            } else if (command.equals("down")) {
                isWon = movePlayer(matrix, +1, 0);
            } else if (command.equals("right")) {
                isWon = movePlayer(matrix, 0, +1);
            } else if (command.equals("left")) {
                isWon = movePlayer(matrix, 0, -1);
            }

            if (isWon) {
                break;
            }
        }

        if (isWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        System.out.println(getMatrixString(matrix));

    }

    private static boolean movePlayer(char[][] matrix, int rowAddition, int colAddition) {
        boolean isWonTheGame = false;

        matrix[playerRow][playerCol] = '.';

        int newRow = setNewValues(playerRow + rowAddition, matrix.length);
        int newCol = setNewValues(playerCol + colAddition, matrix.length);

        if (matrix[newRow][newCol] == 'T') {
            return isWonTheGame;
        }

        if (matrix[newRow][newCol] == 'B') {
            newRow = setNewValues(newRow + rowAddition, matrix.length);
            newCol = setNewValues(newCol + colAddition, matrix.length);
        }

        if (matrix[newRow][newCol] == 'F') {
            isWonTheGame = true;
        }

        playerRow = newRow;
        playerCol = newCol;

        matrix[playerRow][playerCol] = 'P';

        return isWonTheGame;
    }

    private static int setNewValues(int value, int size) {
        //ако е вътре в матрицата ред или колона -> връщам стойността
        //ако е извън -> връщаме новата стойност
        if (value < 0) {
            value = size - 1;
        } else if (value >= size) {
            value = 0;
        }
        return value;
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

    private static void fillMatrix(Scanner scan, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String line = scan.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("P")) {
                playerRow = row;
                playerCol = line.indexOf("P");
            }
        }
    }
}
