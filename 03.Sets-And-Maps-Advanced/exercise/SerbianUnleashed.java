package T3SetsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, Integer>> venuesData = new LinkedHashMap<>();
        String regex = "(?<singer>[A-Za-z]+ *[A-Za-z]* *[A-Za-z]*) @(?<venue>[A-Za-z]+ *[A-Za-z]* *[A-Za-z]*) (?<price>[0-9]+) (?<count>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int ticketsPrice = Integer.parseInt(matcher.group("price"));
                int ticketsCount = Integer.parseInt(matcher.group("count"));

                venuesData.putIfAbsent(venue, new LinkedHashMap<>());
                if (!venuesData.get(venue).containsKey(singer)) {
                    venuesData.get(venue).put(singer, ticketsPrice * ticketsCount);
                } else {
                    venuesData.get(venue)
                            .put(singer, venuesData.get(venue).get(singer) + (ticketsPrice * ticketsCount));
                }

            }
            input = scan.nextLine();
        }
        venuesData.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> System.out.println("#  " + entry.getKey() + " -> " + entry.getValue()));
        });
    }
}
