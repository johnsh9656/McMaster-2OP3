package q2;

public class ElectricCar extends Car {
    // eletric-specific attributes
    private double batteryCapacity;
    private double milesPerKWh;
    private double currentCharge;

    // constructor building on super
    public ElectricCar(String make, String model, double batteryCapacity, double milesPerKWh) {
        super(make, model);
        this.batteryCapacity = batteryCapacity;
        this.milesPerKWh = milesPerKWh;
        this.currentCharge = 0;
    }

    // implementing the abstract methods
    @Override
    public double calculateFuelEfficiency() {
        return milesPerKWh;
    }
    
    @Override
    public double calculateRange() {
        return batteryCapacity * milesPerKWh;
    }
}
