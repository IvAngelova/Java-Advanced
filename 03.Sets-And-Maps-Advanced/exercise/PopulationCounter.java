package T3SetsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> countryData = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            countryData.putIfAbsent(country, new LinkedHashMap<>());
            countryData.get(country).put(city, population);

            input = scan.nextLine();
        }

        LinkedHashMap<String, Long> countriesTotalPopulation = new LinkedHashMap<>();
        countryData.entrySet().forEach(e -> {
            long totalPopulation = e.getValue().values().stream().mapToLong(x -> x).sum();
            countriesTotalPopulation.put(e.getKey(), totalPopulation);
        });

        //print
        countriesTotalPopulation.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    System.out.println(String.format("%s (total population: %d)", e.getKey(), e.getValue()));
                    //сортиране на градовете за всяка държава
                    countryData.get(e.getKey()).entrySet().stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(entry ->
                                    System.out.printf("=>%s: %d%n", entry.getKey(), entry.getValue()));
                });
    }
}
