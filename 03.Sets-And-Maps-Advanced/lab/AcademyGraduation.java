package T3SetsAndMaps.lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, double[]> studentsGrades = new TreeMap<>();
        while (n-- > 0) {
            String name = scan.nextLine();
            double[] grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            studentsGrades.put(name, grades);
        }
        studentsGrades.entrySet().stream().forEach(e -> {
            double avgSum = 0;
            for (int i = 0; i < e.getValue().length; i++) {
                avgSum += e.getValue()[i];
            }
            avgSum /= e.getValue().length;
            DecimalFormat df = new DecimalFormat("#.##################");
            System.out.printf("%s is graduated with %s%n", e.getKey(), df.format(avgSum));
        });
    }
}
