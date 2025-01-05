package DefiningClassesRawData;

public class Tire {
    public double tyrePressure;
    public int tyreAge;

    public Tire(double tyrePressure, int tyreAge) {
        this.tyrePressure = tyrePressure;
        this.tyreAge = tyreAge;
    }

    public double getTyrePressure() {
        return tyrePressure;
    }
}
