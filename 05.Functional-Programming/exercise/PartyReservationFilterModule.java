package T5FunctionalProgramming.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> people = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = scan.nextLine();

        List<String> filters = new ArrayList<>();

        while (!input.equals("Print")) {

            String[] tokens = input.split(";");
            String command = tokens[0];
            String filterType = tokens[1];
            String filterParameter = tokens[2];

            if (command.equals("Add filter")) {
                filters.add(filterType + "&" + filterParameter);
            } else if (command.equals("Remove filter")) {
                filters.remove(filterType + "&" + filterParameter);
            }

            input = scan.nextLine();
        }
        for (String filter : filters) {
            //filter -> Starts with&P
            String[] tokens = filter.split("&");
            String filterType = tokens[0];
            String filterParameter = tokens[1];
            people.removeIf(getPredicate(filterType, filterParameter));
//            for (int index = people.size() - 1; index >= 0; index--) {
//                String currentName = people.get(index);
//                if (getPredicate(filterType, filterParameter).test(currentName)) {
//                    people.remove(currentName);
//                }
//            }
        }

        people.forEach(e -> System.out.print(e + " "));
    }

    private static Predicate<String> getPredicate(String type, String parameter) {
        switch (type) {
            case "Starts with":
                return name -> name.startsWith(parameter);
            case "Ends with":
                return name -> name.endsWith(parameter);
            case "Length":
                return name -> name.length() == Integer.parseInt(parameter);
            case "Contains":
                return name -> name.contains(parameter);

        }
        return name -> false;
    }
}
