package ExamPrep;

import java.util.Scanner;

public class Selling_02 {
    static int rowPosition = 0, colPosition = 0, money = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];
        fillMatrix(scan, matrix, size);

        boolean outOfTheBakery = false;

        while (money < 50) {
            String command = scan.nextLine();
            switch (command) {
                case "up":
                    outOfTheBakery = move(matrix, -1, 0);
                    break;
                case "down":
                    outOfTheBakery = move(matrix, +1, 0);
                    break;
                case "right":
                    outOfTheBakery = move(matrix, 0, +1);
                    break;
                case "left":
                    outOfTheBakery = move(matrix, 0, -1);
                    break;
            }

            if(outOfTheBakery){
                break;
            }

        }


        if(outOfTheBakery){
            System.out.println("Bad news, you are out of the bakery.");
        }else{
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + money);

        System.out.println(getMatrixString(matrix));
    }

    private static boolean move(char[][] matrix, int rowAddition, int colAddition) {

        matrix[rowPosition][colPosition] = '-';

        if (isInBounds(matrix, rowPosition + rowAddition, colPosition + colAddition)) {
            if (Character.isDigit(matrix[rowPosition + rowAddition][colPosition + colAddition])) {
                String digitAsString = Character.toString(matrix[rowPosition + rowAddition][colPosition + colAddition]);
                int digit = Integer.parseInt(digitAsString);
                money += digit;
                rowPosition += rowAddition;
                colPosition += colAddition;
            } else if (matrix[rowPosition + rowAddition][colPosition + colAddition] == 'O') {
                matrix[rowPosition + rowAddition][colPosition + colAddition] = '-';
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix.length; col++) {
                        if (matrix[row][col] == 'O') {
                            rowPosition = row;
                            colPosition = col;
                        }
                    }
                }
            }else if(matrix[rowPosition + rowAddition][colPosition + colAddition] == '-'){
                rowPosition += rowAddition;
                colPosition += colAddition;
            }
        } else {
            //outOfBounds
            return true;
        }

        matrix[rowPosition][colPosition] = 'S';
        return false;
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void fillMatrix(Scanner scan, char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            String line = scan.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("S")) {
                rowPosition = row;
                colPosition = line.indexOf("S");
            }
        }
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

}
