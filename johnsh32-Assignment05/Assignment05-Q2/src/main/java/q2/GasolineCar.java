package q2;

public class GasolineCar extends Car {
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
}
