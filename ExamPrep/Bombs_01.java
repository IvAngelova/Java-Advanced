package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> queueEffects = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackBombCasing = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).forEach(stackBombCasing::push);

        //•	Datura Bombs: 40
        //•	Cherry Bombs: 60
        //•	Smoke Decoy Bombs: 120

        TreeMap<String, int[]> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", new int[]{40, 0});
        bombs.put("Cherry Bombs", new int[]{60, 0});
        bombs.put("Smoke Decoy Bombs", new int[]{120, 0});

        boolean isBombPouchFilled = false;

        while (!queueEffects.isEmpty() && !stackBombCasing.isEmpty()) {
            int firstEffect = queueEffects.peek();
            int lastBombCasing = stackBombCasing.pop();
            boolean isMadeABomb = false;
            for (Map.Entry<String, int[]> entry : bombs.entrySet()) {
                if (firstEffect + lastBombCasing == entry.getValue()[0]) {
                    bombs.get(entry.getKey())[1]++;
                    queueEffects.poll();
                    isMadeABomb = true;
                    break;
                }
            }

            if (bombs.get("Datura Bombs")[1] >= 3 && bombs.get("Cherry Bombs")[1] >= 3
                    && bombs.get("Smoke Decoy Bombs")[1] >= 3) {
                isBombPouchFilled = true;
                break;
            }
            if (!isMadeABomb) {
                lastBombCasing -= 5;
                stackBombCasing.push(lastBombCasing);
            }
        }

        if (isBombPouchFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (queueEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            System.out.println(queueEffects.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        if (stackBombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            System.out.println(stackBombCasing.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        bombs.entrySet().forEach(e ->
                System.out.println(e.getKey() + ": " + e.getValue()[1]));
    }

}
