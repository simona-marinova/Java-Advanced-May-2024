package DefiningClassesSpeedRacing;

import java.util.List;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostOneKm;
    private int distanceTraveled;

    public Car(String model,double fuelAmount, double fuelCostOneKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostOneKm = fuelCostOneKm;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public void drive(int amountOfKm) {
        double fuelNeeded = amountOfKm*this.fuelCostOneKm;
        if(fuelNeeded<=this.fuelAmount){
            this.distanceTraveled+=amountOfKm;
            this.fuelAmount-=fuelNeeded;
        }
        else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String toString() {
            //{Model} {fuelAmount} {distanceTraveled}
            return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
        }

    }

