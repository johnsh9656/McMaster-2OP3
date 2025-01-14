package q6;

public abstract class LuxuryCar extends Car  {
    // attributes for all luxury cars
    private boolean isConvertible;
    private boolean hasSunroof;

    // constructor building on the super
    public LuxuryCar(String make, String model, boolean isConvertible, boolean hasSunroof) {
        super(make, model);
        this.isConvertible = isConvertible;
        this.hasSunroof = hasSunroof;
    }

    // getter methods for luxury attributes
    public boolean isConvertible() {
        return isConvertible;
    }

    public boolean hasSunroof() {
        return hasSunroof;
    }
}