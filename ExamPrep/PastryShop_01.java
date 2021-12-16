package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] liquids = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] ingredients = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queueLiquids = new ArrayDeque<>();
        for (int liquid : liquids) {
            queueLiquids.offer(liquid);
        }
        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();
        for (int ingredient : ingredients) {
            stackIngredients.push(ingredient);
        }
        LinkedHashMap<String, int[]> food = new LinkedHashMap<>();
        //food -> {value[0], count[1]}
        food.put("Biscuit", new int[]{25, 0});
        food.put("Cake", new int[]{50, 0});
        food.put("Pie", new int[]{100, 0});
        food.put("Pastry", new int[]{75, 0});

        while (queueLiquids.size() != 0 && stackIngredients.size() != 0) {
            int firstLiquid = queueLiquids.poll();
            int lastIngredient = stackIngredients.pop();
            boolean isCooked = false;
            for (Map.Entry<String, int[]> entry : food.entrySet()) {
                if (firstLiquid + lastIngredient == entry.getValue()[0]) {
                    food.get(entry.getKey())[1]++;
                    isCooked = true;
                    break;
                }
            }
            if (!isCooked) {
                lastIngredient += 3;
                stackIngredients.push(lastIngredient);

            }

        }

        boolean allFoodIsCooked = false;

        if (food.get("Biscuit")[1] >= 1 && food.get("Cake")[1] >= 1 && food.get("Pastry")[1] >= 1 &&
                food.get("Pie")[1] >= 1){
            allFoodIsCooked = true;
        }


        if (allFoodIsCooked) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (queueLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            print(queueLiquids);
        }
        if (stackIngredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            print(stackIngredients);
        }
        food.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()[1]));


    }

    private static void print(ArrayDeque<Integer> arrayDeque) {
        String output = arrayDeque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(output);
    }
}
