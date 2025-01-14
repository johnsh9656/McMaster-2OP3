package q5;

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
}
