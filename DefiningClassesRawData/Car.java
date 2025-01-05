package DefiningClassesRawData;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public String model;
    public Engine engine;
    public Cargo cargo;
    List<Tire> tires = new ArrayList<>(4);

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = new ArrayList<>(4);
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    public void toStringFragile() {
        StringBuilder sb = new StringBuilder();
        if(cargo.getCargoType().equals("fragile")){
            for (Tire tire : this.tires) {
                if(tire.getTyrePressure()<1){
                    System.out.println(model);
                    break;
                }
            }
        }
    }

    public void toStringFlamable() {
        StringBuilder sb = new StringBuilder();
       if(cargo.getCargoType().equals("flamable")){
            if(engine.getEnginePower()>250){
                System.out.println(model);
            }
        }
    }
}
