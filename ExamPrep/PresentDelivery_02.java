package ExamPrep;

import java.util.Scanner;

public class PresentDelivery_02 {
    public static int santaRow = 0, santaCol = 0, countNiceKids = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countPresents = Integer.parseInt(scan.nextLine());
        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];
        fillMatrix(scan, matrix, size);
        int allNiceKids = countNiceKids;

        String command = scan.nextLine();
        while (!command.equals("Christmas morning")) {

            switch (command) {
                case "up":
                    countPresents = moveSanta(matrix, -1, 0, countPresents);
                    break;
                case "down":
                    countPresents = moveSanta(matrix, +1, 0, countPresents);
                    break;
                case "left":
                    countPresents = moveSanta(matrix, 0, -1, countPresents);
                    break;
                case "right":
                    countPresents = moveSanta(matrix, 0, +1, countPresents);
                    break;
            }

            if (countPresents == 0) {
                break;
            }

            command = scan.nextLine();
        }

        if (countPresents == 0) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix, size);

        if (countNiceKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", allNiceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", countNiceKids);
        }

    }

    private static void printMatrix(char[][] matrix, int size) {
        for (char[] line : matrix) {
            for (char symbol : line) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    private static int moveSanta(char[][] matrix, int rowAddition, int colAddition, int countPresents) {
        matrix[santaRow][santaCol] = '-';
        santaRow += rowAddition;
        santaCol += colAddition;
        if (matrix[santaRow][santaCol] == 'V') {
            countNiceKids--;
            countPresents--;
        } else if (matrix[santaRow][santaCol] == 'C') {
            countPresents = santaEatsCookies(matrix, -1, 0, countPresents);
            if (countPresents == 0) {
                return countPresents;
            }
            countPresents = santaEatsCookies(matrix, +1, 0, countPresents);
            if (countPresents == 0) {
                return countPresents;
            }
            countPresents = santaEatsCookies(matrix, 0, -1, countPresents);
            if (countPresents == 0) {
                return countPresents;
            }
            countPresents = santaEatsCookies(matrix, 0, +1, countPresents);
            if (countPresents == 0) {
                return countPresents;
            }
        }

        matrix[santaRow][santaCol] = 'S';
        return countPresents;
    }

    private static int santaEatsCookies(char[][] matrix, int rowModification, int colModification, int countPresents) {

        if (matrix[santaRow + rowModification][santaCol + colModification] == 'V') {
            countNiceKids--;
            countPresents--;
        } else if (matrix[santaRow + rowModification][santaCol + colModification] == 'X') {
            countPresents--;
        }

        matrix[santaRow + rowModification][santaCol + colModification] = '-';

        return countPresents;
    }

    private static void fillMatrix(Scanner scan, char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line[col].charAt(0);
                if (matrix[row][col] == 'S') {
                    santaRow = row;
                    santaCol = col;
                }
                if (matrix[row][col] == 'V') {
                    countNiceKids++;
                }
            }
        }
    }
}
