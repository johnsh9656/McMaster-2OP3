package q5;

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

    // test with other car types in FleetManager
    public static void main(String[] args) {

        ArrayList<Car> fleet = new ArrayList<>();

        // hyrbrid car with battery
        HybridCar car1 = new HybridCar("Toyota", "Prius", 11.9, 50.0, 8.8, 3.5);
        car1.refuel(20.0, 10.0); // refuel gas and battery
        fleet.add(car1);

        // gas only hybrid
        HybridCar car2 = new HybridCar("Ford", "Fusion", 14.0, 24.8);
        car2.refuel(20.0, 10.0); // refuel gas and battery
        fleet.add(car2);

        // electric-only hybrid
        HybridCar car3 = new HybridCar("Chevrolet", "Volt", 0, 0, 12.2, 6.7);
        car3.refuel(20.0, 10.0); // refuel gas and battery
        fleet.add(car3);
        

        // hybrid car without battery 

        // make sure it works with other car types
        GasolineCar car4 = new GasolineCar("Toyota", "Corolla", 13.2, 30.0);
        car4.refuel(10.0);
        fleet.add(car4);

        ElectricCar car5 = new ElectricCar("Tesla", "Model 3", 75.0, 4.0);
        car5.refuel(50.0);
        fleet.add(car5);

        // instantiate new fleet manager
        FleetManager fleetManager = new FleetManager(fleet);

        // display details of the fleet
        System.out.println("Fleet Details:");
        fleetManager.displayFleetDetails();

        // calculate and display total fleet range
        double totalRange = fleetManager.calculateTotalFleetRange();
        System.out.println("Total Fleet Range: " + totalRange + " miles");
    }
}
