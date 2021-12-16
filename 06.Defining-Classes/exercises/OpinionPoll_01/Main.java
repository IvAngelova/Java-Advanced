package T6DefiningClasses.exercises.OpinionPoll_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] personalData = scan.nextLine().split("\\s+");
            String name = personalData[0];
            int age = Integer.parseInt(personalData[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people
                .stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(p -> p.getName()))
                .forEach(p-> System.out.println(p.toString()));
    }
}
