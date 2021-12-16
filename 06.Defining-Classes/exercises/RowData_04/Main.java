package T6DefiningClasses.exercises.RowData_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        LinkedHashSet<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];

            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            Engine engine = new Engine(speed, power);

            int weight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Cargo cargo = new Cargo(weight, cargoType);

            Car car = new Car(model, engine, cargo);

            for (int index = 5; index < input.length; index += 2) {
                double pressure = Double.parseDouble(input[index]);
                int age = Integer.parseInt(input[index + 1]);
                Tire tire = new Tire(pressure, age);
                car.getTiresList().add(tire);
            }

            cars.add(car);
        }

        String command = scan.nextLine();
        if (command.equals("fragile")) {
            for (Car car : cars) {
                if (car.getCargo().getType().equals("fragile")) {
                    for (Tire tire : car.getTiresList()) {
                        if (tire.getPressure() < 1) {
                            System.out.println(car.getModel());
                            break;
                        }
                    }
                }
            }

        } else if (command.equals("flamable")) {
            for (Car car : cars) {
                if (car.getCargo().getType().equals("flamable") && car.getEngine().getPower() > 250) {
                    System.out.println(car.getModel());
                }
            }

        }
    }
}
