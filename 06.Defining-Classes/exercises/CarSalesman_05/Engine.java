package T6DefiningClasses.exercises.CarSalesman_05;

public class Engine {
    private String model;
    private int power;
    //optional
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, 0, "n/a");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, 0, efficiency);
    }

    //output format
    //{EngineModel}:
    //Power: {EnginePower}
    //Displacement: {EngineDisplacement}
    //Efficiency: {EngineEfficiency}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":\n");
        sb.append("Power: ").append(this.power).append("\n");
        if (this.displacement == 0) {
            sb.append("Displacement: ").append("n/a\n");
        } else {
            sb.append("Displacement: ").append(this.displacement).append("\n");
        }
        sb.append("Efficiency: ").append(this.efficiency).append("\n");

        return sb.toString();
    }
}
