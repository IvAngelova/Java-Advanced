package T6DefiningClasses.exercises.SpeedRacing_03;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] carData = scan.nextLine().split("\\s+");
            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double consumptionFuel = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, consumptionFuel);
            cars.put(model, car);
        }

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String model = input.split("\\s+")[1];
            int distance = Integer.parseInt(input.split("\\s+")[2]);
            Car carToDrive = cars.get(model);
            if (!carToDrive.drive(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }
            input = scan.nextLine();
        }

        cars.entrySet().stream().forEach(e-> System.out.println(e.getValue().toString()));
    }
}
