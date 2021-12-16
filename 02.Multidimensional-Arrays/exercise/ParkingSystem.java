package T2MultidimensionalsArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensionsParking = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensionsParking[0];
        int cols = dimensionsParking[1];
        boolean[][] parkingMatrix = new boolean[rows][cols]; // Матрицата е пълна с false -> default value
        for (int row = 0; row < parkingMatrix.length; row++) {
            parkingMatrix[row][0] = true; //където е true не може да се паркира или е заето мястото
        }

        String input = scan.nextLine();
        while (!input.equals("stop")) {
            String[] tokens = input.split(" ");
            int entryRow = Integer.parseInt(tokens[0]);
            int rowCoordinate = Integer.parseInt(tokens[1]);
            int colCoordinate = Integer.parseInt(tokens[2]);
            boolean hasFoundFreePlace = false;

            int traveledDistance = 1;
            traveledDistance += Math.abs(rowCoordinate - entryRow);

            //ако мястото е свободно
            if (!parkingMatrix[rowCoordinate][colCoordinate]) { //!false = true
                parkingMatrix[rowCoordinate][colCoordinate] = true;
                traveledDistance += colCoordinate;
                hasFoundFreePlace = true;
            } else {
                //ако мястото не е свободно
                for (int i = 1; i <= parkingMatrix[rowCoordinate].length; i++) {
                    if (colCoordinate - i > 0 && !parkingMatrix[rowCoordinate][colCoordinate - i]) {
                        parkingMatrix[rowCoordinate][colCoordinate - i] = true;
                        hasFoundFreePlace = true;
                        traveledDistance += colCoordinate - i;
                        break;
                    }
                    if (colCoordinate + i < parkingMatrix[rowCoordinate].length &&
                            !parkingMatrix[rowCoordinate][colCoordinate + i]) {
                        parkingMatrix[rowCoordinate][colCoordinate + i] = true;
                        hasFoundFreePlace = true;
                        traveledDistance += colCoordinate + i;
                        break;
                    }
                }
            }

            if (hasFoundFreePlace) {
                System.out.println(traveledDistance);
            } else {
                System.out.printf("Row %d full", rowCoordinate);
            }

            input = scan.nextLine();
        }
    }
}
