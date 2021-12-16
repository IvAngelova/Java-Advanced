package T3SetsAndMaps.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        TreeMap<String, List<Double>> studentsGrades = new TreeMap<>();

        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            studentsGrades.putIfAbsent(name, new ArrayList<>());
            studentsGrades.get(name).add(grade);
        }
        studentsGrades.entrySet().stream().forEach(e -> {
            System.out.printf("%s -> ", e.getKey());
            e.getValue().forEach(element -> System.out.printf("%.2f ", element));
            // double avg = e.getValue().stream().mapToDouble(x -> x).average().orElse(0);
            double avgSum = 0;
            for (int i = 0; i < e.getValue().size(); i++) {
                avgSum += e.getValue().get(i);
            }
            avgSum /= e.getValue().size();
            System.out.printf("(avg: %.2f)%n", avgSum);
        });
    }
}
