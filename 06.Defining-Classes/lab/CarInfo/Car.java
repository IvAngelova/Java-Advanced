package T6DefiningClasses.lab.CarInfo;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String brand) {
        //Constructor Chaining
        this(brand, "unknown", -1);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String carInfo() {
        return toString();
    }

    @Override  //автоматично генериран equals method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return horsePower == car.horsePower && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (this == obj) { // check addresses in memory
//            return true;
//        }
//        if(obj instanceof Car){
//            Car other = (Car) obj;
//            return
//                    this.brand.equals(other.brand)
//                    && this.model.equals(other.model)
//                    && this.horsePower == other.horsePower;
//        }
//        return false;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, horsePower);
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(),
                this.getModel(), this.getHorsePower());

    }
}
