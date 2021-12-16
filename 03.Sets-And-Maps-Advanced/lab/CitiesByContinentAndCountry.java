package T3SetsAndMaps.lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> data = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            data.putIfAbsent(continent, new LinkedHashMap<>());
            data.get(continent).putIfAbsent(country, new ArrayList<>());
            data.get(continent).get(country).add(city);
        }
        data.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + ":");
            e.getValue().entrySet().forEach(entry ->
                    System.out.println("  " + entry.getKey() + " -> " + String.join(", ", entry.getValue())));
        });
    }
}
