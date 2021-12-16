package ExamPrep.dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        if (!this.data.isEmpty()) {
            return this.data.stream().max(Comparator.comparingInt(Car::getYear)).get();
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        if (!this.data.isEmpty()) {
            for (Car car : data) {
                if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                    return car;
                }
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car ExamPrep.dealership ").append(name).append(":").append(System.lineSeparator());
        this.data.forEach(c -> sb.append(c).append(System.lineSeparator()));
        return sb.toString();
    }
}
