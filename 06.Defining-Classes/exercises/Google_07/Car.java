package T6DefiningClasses.exercises.Google_07;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return this.model + " " + this.speed;
    }
}
