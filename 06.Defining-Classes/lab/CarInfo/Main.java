package T6DefiningClasses.lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            Car car;
            if (tokens.length == 1) {
                car = new Car(tokens[0]);
            } else {
                car = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }

            cars.add(car);
        }
        //cars.forEach(c -> System.out.println(c.carInfo()));
        System.out.println(cars
                .stream()
                .map(c -> c.toString())
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
