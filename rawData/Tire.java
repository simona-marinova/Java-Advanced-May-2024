package rawData;

public class Tire {
    private double pressure;
    private int age;

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }

    public int getAge() {
        return age;
    }
}
