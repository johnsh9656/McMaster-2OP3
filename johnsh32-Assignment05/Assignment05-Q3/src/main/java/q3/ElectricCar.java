package q3;

public class ElectricCar extends Car implements Refuelable {
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


    // implement inteface method
    public void refuel(double refuelAmount) {
        if (refuelAmount <= 0) {
            // don't refill if  invalid number
            System.out.println("Amount to refuel must be positive");
        }
        else if (currentCharge + refuelAmount > batteryCapacity) {
            // only refill up to capacity
            currentCharge = batteryCapacity;
        }
        else {
            currentCharge += refuelAmount;
        }
    }
}
