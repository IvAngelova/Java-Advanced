package T6DefiningClasses.exercises.SpeedRacing_03;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostFor1Km;
    private int traveledDistance;

    public Car(String model, double fuelAmount, double fuelCostFor1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
        this.traveledDistance = 0;
    }

    public boolean drive(int distance) {
        double neededFuel = distance * this.fuelCostFor1Km;
        if (neededFuel <= this.fuelAmount){
            this.fuelAmount -= neededFuel;
            this.traveledDistance += distance;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, traveledDistance);
    }
}
