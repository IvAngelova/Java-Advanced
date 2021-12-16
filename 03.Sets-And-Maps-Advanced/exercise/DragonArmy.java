package T3SetsAndMaps.exercise;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, TreeMap<String, int[]>> dragonArmy = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            int damage = getValue(input[2], 45);
            int health = getValue(input[3], 250);
            int armor = getValue(input[4], 10);

            dragonArmy.putIfAbsent(type, new TreeMap<>());
            dragonArmy.get(type).put(name, new int[]{damage, health, armor});
        }

        dragonArmy.entrySet().stream().forEach(e -> {

            double avgDamage = 0;
            for (Map.Entry<String, int[]> entry : e.getValue().entrySet()) {
                avgDamage += entry.getValue()[0];
            }
            avgDamage /= e.getValue().entrySet().size();

            double avgHealth = 0;
            for (Map.Entry<String, int[]> entry : e.getValue().entrySet()) {
                avgHealth += entry.getValue()[1];
            }
            avgHealth /= e.getValue().entrySet().size();

            double avgArmor = 0;
            for (Map.Entry<String, int[]> entry : e.getValue().entrySet()) {
                avgArmor += entry.getValue()[2];
            }
            avgArmor /= e.getValue().entrySet().size();

            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", e.getKey(),
                    avgDamage, avgHealth, avgArmor));

            e.getValue().entrySet().forEach(kvp ->
                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", kvp.getKey(),
                            kvp.getValue()[0], kvp.getValue()[1], kvp.getValue()[2]));
        });
    }


    private static int getValue(String input, int defaultValue) {
        if (input.equals("null")) {
            return defaultValue;
        }
        return Integer.parseInt(input);
    }
}
