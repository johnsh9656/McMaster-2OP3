package q5;

public abstract class Car {
    // attributes for all cars
    private String make;
    private String model;

    // constructor for Car
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // attribute getter methods
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    // abstract methods
    public abstract double calculateFuelEfficiency();

    public abstract double calculateRange();
}
