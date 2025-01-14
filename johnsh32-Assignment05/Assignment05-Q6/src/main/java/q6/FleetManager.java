package q6;

import java.util.ArrayList;

public class FleetManager {

    private ArrayList<Car> fleet;

    // constructor sets fleet ArrayList
    public FleetManager(ArrayList<Car> fleet) {
        this.fleet = fleet;
    }

    // outputs general car attributues of each car in fleet
    public void displayFleetDetails() {
        for (Car car : fleet) {
            System.out.println("Car: " + car.getMake() + " " + car.getModel());
            System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " miles/unit");
            System.out.println("Range: " + car.calculateRange() + " miles");
            System.out.println("");
        }
    }

    // returns sum of ranges of each car in fleet
    public double calculateTotalFleetRange() {
        double totalRange = 0;
        for (Car car : fleet) {
            totalRange += car.calculateRange();
        }
        return totalRange;
    }


    public static void main(String[] args) {

        ArrayList<Car> fleet = new ArrayList<>();

        // various types of cars in fleet
        GasolineCar car1 = new GasolineCar("Toyota", "Corolla", 13.2, 30.0);
        car1.refuel(10.0);
        fleet.add(car1);

        ElectricCar car2 = new ElectricCar("Tesla", "Model 3", 75.0, 4.0);
        car2.refuel(50.0);
        fleet.add(car2);

        HybridCar car3 = new HybridCar("Toyota", "Prius", 11.9, 50.0, 8.8, 3.5);
        car3.refuel(20.0, 10.0);
        fleet.add(car3);
        
        LuxurySedan car4 = new LuxurySedan("Mercedes", "S-Class", true, true, 28.2, 12.0);
        car4.refuel(22.4);
        fleet.add(car4);


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
