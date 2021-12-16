package Exam;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> queueIngredients = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackFreshness = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackFreshness::push);

        TreeMap<String, int[]> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", new int[]{150, 0});
        cocktails.put("The Harvest", new int[]{250, 0});
        cocktails.put("Apple Hinny", new int[]{300, 0});
        cocktails.put("High Fashion", new int[]{400, 0});

        while (!queueIngredients.isEmpty() && !stackFreshness.isEmpty()) {
            int firstIngredients = queueIngredients.peek();

            if (firstIngredients == 0) {
                queueIngredients.poll();
                continue;
            }

            firstIngredients = queueIngredients.poll();
            int lastFreshnessLevel = stackFreshness.pop();

            boolean isMadeCocktail = false;
            for (Map.Entry<String, int[]> entry : cocktails.entrySet()) {
                if (firstIngredients * lastFreshnessLevel == entry.getValue()[0]) {
                    cocktails.get(entry.getKey())[1]++;
                    isMadeCocktail = true;
                    break;
                }
            }
            if (!isMadeCocktail) {
                firstIngredients += 5;
                queueIngredients.offer(firstIngredients);
            }
        }

        boolean allCocktailsAreMade = false;

        if (cocktails.get("Pear Sour")[1] >= 1 && cocktails.get("The Harvest")[1] >= 1
                && cocktails.get("Apple Hinny")[1] >= 1 && cocktails.get("High Fashion")[1] >= 1) {
            allCocktailsAreMade = true;
        }

        if (allCocktailsAreMade) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!queueIngredients.isEmpty()) {
            System.out.print("Ingredients left: ");
            System.out.println(queueIngredients.stream().mapToInt(e -> e).sum());
        }

        cocktails.entrySet().stream().filter(e -> e.getValue()[1] >= 1)
                .forEach(e -> System.out.printf(" # %s --> %d%n", e.getKey(), e.getValue()[1]));
    }
}
