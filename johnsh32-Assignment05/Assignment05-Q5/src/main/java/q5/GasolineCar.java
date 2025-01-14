package q5;

public class GasolineCar extends Car  implements Refuelable {
    // gasoline-specific attributes
    private double fuelTankCapacity;
    private double milesPerGallon;
    private double currentFuelLevel;

    // constructor building on super
    public GasolineCar(String make, String model, double fuelTankCapacity, double milesPerGallon) {
        super(make, model);
        this.fuelTankCapacity = fuelTankCapacity;
        this.milesPerGallon = milesPerGallon;
        this.currentFuelLevel = 0;
    }

    // implementing abstract methods
    @Override
    public double calculateFuelEfficiency() {
        return milesPerGallon;
    }
    
    @Override
    public double calculateRange() {
        return fuelTankCapacity * milesPerGallon;
    }

    // implement interface method
    public void refuel(double refuelAmount) {
        if (refuelAmount <= 0) {            
            // don't refill if  invalid number
            System.out.println("Amount to refuel must be positive");
        }
        else if (currentFuelLevel + refuelAmount > fuelTankCapacity) {
            // refill only up to capacity
            currentFuelLevel = fuelTankCapacity;
        }
        else {
            currentFuelLevel += refuelAmount;
        }
    }
}
