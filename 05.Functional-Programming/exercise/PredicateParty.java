package T5FunctionalProgramming.exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> people = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String input = scan.nextLine();

        while (!input.equals("Party!")) {
            String command = input.split("\\s+")[0];
            String typeOfCommand = input.split("\\s+")[1];
            String argument = input.split("\\s+")[2];
            if (command.equals("Remove")) {
                people.removeIf(getPredicate(typeOfCommand, argument));
            } else if (command.equals("Double")) {
                List<String> namesToDouble = new ArrayList<>();
                for (String person : people) {
                    if (getPredicate(typeOfCommand, argument).test(person)) {
                       namesToDouble.add(person);
                    }
                }
                people.addAll(namesToDouble);
            }

            input = scan.nextLine();
        }
        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(people);
            System.out.println(String.format("%s are going to the party!", String.join(", ", people)));
        }

    }

    private static Predicate<String> getPredicate(String type, String argument) {
        switch (type) {
            case "StartsWith":
                return name -> name.startsWith(argument);
            case "EndsWith":
                return name -> name.endsWith(argument);
            case "Length":
                return name -> name.length() == Integer.parseInt(argument);
        }
        return name -> false;
    }
}
