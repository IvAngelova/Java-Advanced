package T9IteratorsAndComparators.exercise.ComparingObjects_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            Person person = new Person(name, age, town);
            people.add(person);

            input = scan.nextLine();
        }
        int n = Integer.parseInt(scan.nextLine());
        Person searchedPerson = people.get(n - 1);
        int counterEquals = 0;
        for (Person person : people) {
            if (person.compareTo(searchedPerson) == 0) {
                counterEquals++;
            }
        }
        if (counterEquals == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d",
                    counterEquals, people.size() - counterEquals, people.size()));
        }
    }
}
