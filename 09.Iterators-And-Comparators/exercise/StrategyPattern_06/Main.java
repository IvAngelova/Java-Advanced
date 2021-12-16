package T9IteratorsAndComparators.exercise.StrategyPattern_06;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        //Create 2 TreeSets of type Person, the first should
        //implement the name comparator and the second should implement the age comparator.
        TreeSet<Person> peopleByName = new TreeSet<>(new ComparatorName());
        TreeSet<Person> peopleByAge = new TreeSet<>(new ComparatorAge());

        while (n-- > 0) {
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, age);
            peopleByName.add(person);
            peopleByAge.add(person);
        }
        for (Person person : peopleByName) {
            System.out.println(person.toString());
        }
        for (Person person : peopleByAge) {
            System.out.println(person.toString());
        }

    }
}
