package q6;

public class LuxurySedan extends LuxuryCar implements Refuelable {
    private double fuelTankCapacity;
    private double milesPerGallon;
    private double currentFuelLevel;

    // constructor building on top of super
    public LuxurySedan(String make, String model, boolean isConvertible, boolean hasSunroof, 
                        double fuelTankCapacity, double milesPerGallon) {
        super(make, model, isConvertible, hasSunroof);
        this.fuelTankCapacity = fuelTankCapacity;
        this.milesPerGallon = milesPerGallon;
        this.currentFuelLevel = 0;
    }

    // implement interface method
    public void refuel(double gallons) {
        // handled same as GasolineCar
        if (gallons <= 0) {
            System.out.println("Amount to refuel must be positive");
        }
        else if (currentFuelLevel + gallons > fuelTankCapacity) {
            currentFuelLevel = fuelTankCapacity;
        }
        else {
            currentFuelLevel += gallons;
        }
    }

    // implement super's abstract methods
    @Override
    public double calculateFuelEfficiency() {
        return milesPerGallon;
    }

    @Override
    public double calculateRange() {
        return milesPerGallon * fuelTankCapacity;
    }
}
