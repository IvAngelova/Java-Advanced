package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stackMaterials = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stackMaterials::push);

        ArrayDeque<Integer> queueMagicValues = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); //add

        TreeMap<String, int[]> toys = new TreeMap<>();
        toys.put("Doll", new int[]{150, 0});
        toys.put("Wooden train", new int[]{250, 0});
        toys.put("Teddy bear", new int[]{300, 0});
        toys.put("Bicycle", new int[]{400, 0});

        while (!stackMaterials.isEmpty() && !queueMagicValues.isEmpty()) {
            int lastMaterialsBox = stackMaterials.pop();
            int firstMagicValue = queueMagicValues.peek();
            boolean isAPresentMade = false;
            for (Map.Entry<String, int[]> entry : toys.entrySet()) {
                if (lastMaterialsBox * firstMagicValue == entry.getValue()[0]) {
                    entry.getValue()[1]++;
                    queueMagicValues.poll();
                    isAPresentMade = true;
                    break;
                }
            }
            if (!isAPresentMade) {
                if (lastMaterialsBox * firstMagicValue < 0) {
                    queueMagicValues.poll();
                    stackMaterials.push(lastMaterialsBox + firstMagicValue);
                } else if (lastMaterialsBox * firstMagicValue > 0) {
                    queueMagicValues.poll();
                    stackMaterials.push(lastMaterialsBox + 15);
                } else if (lastMaterialsBox * firstMagicValue == 0) {
                    if (lastMaterialsBox != 0) {
                        stackMaterials.push(lastMaterialsBox);
                    }
                    if (firstMagicValue == 0) {
                        queueMagicValues.poll();
                    }
                }
            }
        }

        if ((toys.get("Doll")[1] >= 1 && toys.get("Wooden train")[1] >= 1) ||
                (toys.get("Teddy bear")[1] >= 1 && toys.get("Bicycle")[1] >= 1)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!stackMaterials.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(stackMaterials.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (!queueMagicValues.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(queueMagicValues.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        toys.entrySet().stream()
                .filter(t -> t.getValue()[1] >= 1)
                .forEach(t -> System.out.println(t.getKey() + ": " + t.getValue()[1]));

    }
}
