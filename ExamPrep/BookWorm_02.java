package ExamPrep;

import java.util.Scanner;

public class BookWorm_02 {
    public static int playerRow = 0, playerCol = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];
        fillMatrix(scan, matrix, size);
        String command = scan.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    text = movePlayer(text, matrix, -1, 0);
                    break;
                case "down":
                    text = movePlayer(text, matrix, +1, 0);
                    break;
                case "left":
                    text = movePlayer(text, matrix, 0, -1);
                    break;
                case "right":
                    text = movePlayer(text, matrix, 0, +1);
                    break;
            }
            command = scan.nextLine();
        }

        System.out.println(text);
        printMatrix(matrix, size);
    }

    private static String movePlayer(String text, char[][] matrix, int rowAddition, int colAddition) {
        if (isInBounds(matrix, playerRow + rowAddition, playerCol + colAddition)) {
            matrix[playerRow][playerCol] = '-';
            if (Character.isLetter(matrix[playerRow + rowAddition][playerCol + colAddition])) {
                text = text + matrix[playerRow + rowAddition][playerCol + colAddition];
            }

            playerRow += rowAddition;
            playerCol += colAddition;
            matrix[playerRow][playerCol] = 'P';
        } else {
            text = text.substring(0, text.length() - 1);
        }
        return text;
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void printMatrix(char[][] matrix, int size) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scan, char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            String line = scan.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("P")) {
                playerRow = row;
                playerCol = line.indexOf("P");
            }
        }
    }
}
