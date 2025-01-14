package q6;

import java.util.ArrayList;

public class HybridCar extends Car {
    // hybrid-specific attributes
    private double fuelTankCapacity;
    private double milesPerGallon;
    private double currentFuelLevel;
    private double batteryCapacity;
    private double milesPerKWh;
    private double currentCharge;

    // constructor with gasoline and electric parameters
    public HybridCar(String make, String model, double fuelTankCapacity, 
                    double milesPerGallon, double batteryCapacity, double milesPerKWh) {
        super(make, model);
        this.fuelTankCapacity = fuelTankCapacity;
        this.milesPerGallon = milesPerGallon;
        this.batteryCapacity = batteryCapacity;
        this.milesPerKWh = milesPerKWh;
        this.currentFuelLevel = 0;
        this.currentCharge = 0;
    }

    // constructor without electric parameters
    public HybridCar(String make, String model, double fuelTankCapacity, 
                    double milesPerGallon) {
        this(make, model, fuelTankCapacity, milesPerGallon, 0, 0);
    }
    
    // implement override methods
    @Override
    public double calculateFuelEfficiency() {
        double fuelEfficiency = 0;
        
        if (fuelTankCapacity > 0 && milesPerGallon > 0) {
            // add gas efficiency
            fuelEfficiency += fuelTankCapacity * milesPerGallon;
        }
        if (batteryCapacity > 0 && milesPerKWh > 0) {
            // add battery efficiency
            fuelEfficiency += batteryCapacity * milesPerKWh;

            // take average if uses both fuel and battery
            if (fuelEfficiency > batteryCapacity * milesPerKWh) {
                fuelEfficiency /= 2;
            }
        }

        return fuelEfficiency;
    }
    
    @Override
    public double calculateRange() {
        double range = 0;
        
        if (fuelTankCapacity > 0) {
            // add gas range
            range += fuelTankCapacity * milesPerGallon;
        }
        if (batteryCapacity > 0) {
            // add battery range
            range += batteryCapacity * milesPerKWh;
        }
        return range;
    }

    // implement interface method
    public void refuel(double gasRefuel, double batteryRefuel) {
        // gas refuel
        if (fuelTankCapacity > 0) {
            if (gasRefuel <= 0) {
                System.out.println("Amount to refuel gas must be positive");
            }
            else if (currentFuelLevel + gasRefuel > fuelTankCapacity) {
                currentFuelLevel = fuelTankCapacity;
            }
            else {
                currentFuelLevel += gasRefuel;
            }
        }

        // battery refuel
        if (batteryCapacity > 0) {
            if (batteryRefuel <= 0) {
                System.out.println("Amount to refuel battery must be positive");
            }
            else if (currentCharge + batteryRefuel > batteryCapacity) {
                currentCharge = batteryCapacity;
            }
            else {
                currentCharge += batteryRefuel;
            }
        }
    }
}
