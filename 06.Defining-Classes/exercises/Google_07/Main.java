package T6DefiningClasses.exercises.Google_07;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        HashMap<String, Person> people = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            people.putIfAbsent(personName, new Person());

            String command = tokens[1];
            switch (command) {
                case "company":
                    //{companyName} {department} {salary}
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    people.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    //{pokemonName} {pokemonType}
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    people.get(personName).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    //{parentName} {parentBirthday}
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    people.get(personName).getParents().add(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child child = new Child(childName, childBirthday);
                    people.get(personName).getChildren().add(child);
                    break;
                case "car":
                    String model = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    Car car = new Car(model, speed);
                    people.get(personName).setCar(car);
                    break;
            }
            input = scan.nextLine();
        }
        String searchedPerson = scan.nextLine();
        System.out.println(searchedPerson);
        System.out.println(people.get(searchedPerson).toString());

    }
}
