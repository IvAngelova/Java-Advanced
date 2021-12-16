package T2MultidimensionalsArrays.lab;

import java.util.Scanner;

public class FindTheRealQueen {
    public static int SIZE = 8;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] chessboard = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < SIZE; col++) {
                chessboard[row][col] = line[col].charAt(0);
            }
        }
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (chessboard[row][col] == 'q') {
                    if (isValidQueen(chessboard, row, col)) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    private static boolean isValidQueen(char[][] board, int row, int col) {
        return isQueenColumnValid(board, col) &&
                isQueenRowValid(board, row) &&
                isQueenFirstDiagonalValid(board, row, col) &&
                isQueenSecondDiagonalValid(board, row, col);
    }

    private static boolean isQueenSecondDiagonalValid(char[][] board, int row, int col) {
        int queenCount = 0;
        //от текущата царица нагоре вдясно
        //започваме от 1, за да не броим текущата ни царица
        for (int i = 1; row - i >= 0 && col + i < SIZE; i++) {
            if (board[row - i][col + i] == 'q') {
                queenCount++;
            }
        }
        //от текущата царица надолу вляво
        for (int i = 1; row + i < SIZE && col - i >= 0; i++) {
            if (board[row + i][col - i] == 'q') {
                queenCount++;
            }
        }

        return queenCount == 0;
    }

    private static boolean isQueenFirstDiagonalValid(char[][] board, int row, int col) {
        int queenCount = 0;
        //от текущата царица нагоре вляво
        //започваме от 1, за да не броим текущата ни царица
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i] == 'q') {
                queenCount++;
            }
        }
        //от текущата царица надолу вдясно
        for (int i = 1; row + i < SIZE && col + i < SIZE; i++) {
            if (board[row + i][col + i] == 'q') {
                queenCount++;
            }
        }
        return queenCount == 0;
    }

    private static boolean isQueenRowValid(char[][] board, int row) {
        int queenCount = 0;
        for (int col = 0; col < board[row].length; col++) {
            if (board[row][col] == 'q') {
                queenCount++;
            }
        }
        return queenCount == 1;
    }

    private static boolean isQueenColumnValid(char[][] board, int col) {
        int queenCount = 0;
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == 'q') {
                queenCount++;
            }
        }
        return queenCount == 1;
    }
}
