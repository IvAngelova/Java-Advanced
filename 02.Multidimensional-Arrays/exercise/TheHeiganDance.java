package T2MultidimensionalsArrays.exercise;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double pointsPlayer = 18500;
        double pointsHeigan = 3000000;
        double damageHeigan = Double.parseDouble(scan.nextLine());

        int[] positionPlayer = new int[2];
        positionPlayer[0] = 7; //startRow
        positionPlayer[1] = 7; //startCol

        boolean isInCloud = false;

        String lastSpell = "";

        while (pointsPlayer > 0) {

            pointsHeigan -= damageHeigan;

            if (isInCloud) {
                pointsPlayer -= 3500;
                isInCloud = false;
            }
            if (pointsPlayer <= 0) {
                lastSpell = "Cloud";
                break;
            }
            //само ако HealthHeigan > 0, той може да прави заклинания
            if (pointsHeigan <= 0) {
                break;
            }

            String[] input = scan.nextLine().split(" ");
            String spell = input[0];
            int targetRow = Integer.parseInt(input[1]);
            int targetCol = Integer.parseInt(input[2]);
            lastSpell = spell;

            //проверяваме дали изобщо играчът е засегнат от магията
            boolean isPlayerDamaged = checkIsPlayerHit(positionPlayer[0], positionPlayer[1], targetRow, targetCol);

            int damageDone = 0;
            //ако е засегнат проверяваме spell-a
            if (isPlayerDamaged) {
                if (spell.equals("Cloud")) {
                    damageDone = 3500;
                } else {
                    damageDone = 6000;
                }
                boolean canMove = playerCanMoveAndMovePlayer(positionPlayer, targetRow, targetCol);

                if (!canMove) {
                    pointsPlayer -= damageDone;
                    if (spell.equals("Cloud")) {
                        isInCloud = true;
                    }
                }
            }
        }

        if (pointsHeigan > 0) {
            System.out.printf("Heigan: %.2f%n", pointsHeigan);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (pointsPlayer <= 0) {
            lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : lastSpell;
            System.out.printf("Player: Killed by %s%n", lastSpell);
        } else {
            System.out.printf("Player: %.0f%n", pointsPlayer);
        }
        System.out.println(String.format("Final position: %d, %d", positionPlayer[0], positionPlayer[1]));
    }

    private static boolean playerCanMoveAndMovePlayer(int[] position, int targetRow, int targetCol) {
        boolean canMove = true;

        int r = position[0];
        int c = position[1];
        if (r == targetRow && c == targetCol) {
            canMove = false;
            //проверка дали новата позиция е в матрицата и дали новата позиция е засегната от заклинанието
            //ако новата клетка е в матрицата и не е засегната от заклинанието играчът се мести
        } else if (isInBounds(r - 1, c) && !checkIsPlayerHit(r - 1, c, targetRow, targetCol)) {
            r--;
        } else if (isInBounds(r, c + 1) && !checkIsPlayerHit(r, c + 1, targetRow, targetCol)) {
            c++;
        } else if (isInBounds(r + 1, c) && !checkIsPlayerHit(r + 1, c, targetRow, targetCol)) {
            r++;
        } else if (isInBounds(r, c - 1) && !checkIsPlayerHit(r, c - 1, targetRow, targetCol)) {
            c--;
        } else {
            canMove = false;
        }

        position[0] = r;
        position[1] = c;
        return canMove;
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < 15 && col >= 0 && col < 15;
    }

    private static boolean checkIsPlayerHit(int r, int c, int targetRow, int targetCol) {
        return r >= targetRow - 1 && r <= targetRow + 1 &&
                c >= targetCol - 1 && c <= targetCol + 1;
    }
}
