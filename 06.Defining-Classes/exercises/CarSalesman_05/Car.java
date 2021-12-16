package T6DefiningClasses.exercises.CarSalesman_05;

public class Car {
    private String model;
    private Engine engine;
    //optional
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":\n");
        sb.append(engine.toString());
        if (this.weight == 0) {
            sb.append("Weight: ").append("n/a\n");
        } else {
            sb.append("Weight: ").append(this.weight).append("\n");
        }
        sb.append("Color: ").append(this.color);
        return sb.toString();
    }
}
