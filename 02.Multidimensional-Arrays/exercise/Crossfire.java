package T2MultidimensionalsArrays.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();
        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, cols);
        String input = scan.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] tokens = input.split(" ");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            //destroy up, down
            for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
                if (isInBounds(currentRow, col, matrix) && currentRow != row) { //!!!
                    matrix.get(currentRow).remove(col);
                }
            }

            //destroy left, right
            for (int currentCol = col + radius; currentCol >= col - radius; currentCol--) {
                if (isInBounds(row, currentCol, matrix)) {
                    matrix.get(row).remove(currentCol);
                }
            }
            matrix.removeIf(List::isEmpty); //!

            input = scan.nextLine();
        }


        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                System.out.print(matrix.get(row).get(col) + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int currentRow, int currentCol, List<List<Integer>> matrix) {
        return currentRow >= 0 && currentRow < matrix.size() &&
                currentCol >= 0 && currentCol < matrix.get(currentRow).size();
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int startNumber = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(col, startNumber++);
            }
        }
    }
}
