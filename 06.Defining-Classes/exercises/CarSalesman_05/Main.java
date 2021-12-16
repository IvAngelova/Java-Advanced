package T6DefiningClasses.exercises.CarSalesman_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        HashMap<String, Engine> engines = new HashMap<>();

        while (n-- > 0) {
            String[] engineData = scan.nextLine().split("\\s+");
            //"{Model} {Power} {Displacement} {Efficiency}"
            String engineModel = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            Engine engine = null;

            if (engineData.length == 2) {
                engine = new Engine(engineModel, power);
            } else if (engineData.length == 4) {
                int displacement = Integer.parseInt(engineData[2]);
                String efficiency = engineData[3];
                engine = new Engine(engineModel, power, displacement, efficiency);
            } else if (engineData.length == 3) {
                if (engineData[2].matches("^\\d+$")) { //ако стрингът е само от цифри
                    int displacement = Integer.parseInt(engineData[2]);
                    engine = new Engine(engineModel, power, displacement);
                } else {
                    String efficiency = engineData[2];
                    engine = new Engine(engineModel, power, efficiency);
                }
            }
            //add to collection
            engines.put(engineModel, engine);
        }

        int m = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        while (m-- > 0) {
            String[] carData = scan.nextLine().split("\\s+");
            //"{Model} {Engine} {Weight} {Color}"
            String carModel = carData[0];
            String engineModel = carData[1];
            Car car = null;

            if (carData.length == 2) {
                car = new Car(carModel, engines.get(engineModel));
            } else if (carData.length == 4) {
                int weight = Integer.parseInt(carData[2]);
                String color = carData[3];
                car = new Car(carModel, engines.get(engineModel), weight, color);
            } else if (carData.length == 3) {
                try {
                    int weight = Integer.parseInt(carData[2]);
                    car = new Car(carModel, engines.get(engineModel), weight);
                } catch (NumberFormatException e) {
                    String color = carData[2];
                    car = new Car(carModel, engines.get(engineModel), color);
                }
            }
            //add to collection
            cars.add(car);
        }

        cars.forEach(c -> System.out.println(c.toString()));
    }
}
