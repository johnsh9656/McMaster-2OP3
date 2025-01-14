package q4;

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

    // add various types of cars to fleet and test functionality of FleetManager class
    public static void main(String[] args) {
        ArrayList<Car> fleet = new ArrayList<>();

        // add GasolineCar instances
        GasolineCar car1 = new GasolineCar("Toyota", "Corolla", 13.2, 30.0);
        car1.refuel(10.0);
        fleet.add(car1);

        GasolineCar car2 = new GasolineCar("Honda", "Civic", 12.4, 32.0);
        car2.refuel(8.0);
        fleet.add(car2);
        
        // add ElectricCar instances
        ElectricCar car3 = new ElectricCar("Tesla", "Model 3", 75.0, 4.0);
        car3.refuel(50.0);
        fleet.add(car3);

        ElectricCar car4 = new ElectricCar("Nissan", "Leaf", 40.0, 3.0);
        car4.refuel(20.0);
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
