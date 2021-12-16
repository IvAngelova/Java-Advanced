package T3SetsAndMaps.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        LinkedHashMap<Double, Integer> occurrences = new LinkedHashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            double currentNum = numbers[i];
            if (!occurrences.containsKey(currentNum)) {
                occurrences.put(currentNum, 1);
            } else {
                occurrences.put(currentNum, occurrences.get(currentNum) + 1);
            }
        }
        occurrences.entrySet().stream().forEach(e ->
                System.out.printf("%.1f -> %d%n", e.getKey(), e.getValue()));
    }
}
