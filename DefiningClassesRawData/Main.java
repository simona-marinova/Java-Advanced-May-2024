package DefiningClassesRawData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            //"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure} {Tire1Age}
            // {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}",
            // where the speed, power, weight and tire age are integers, tire pressure is a double.
            String[] information = scanner.nextLine().split(" ");
            List<Tire> tires = new ArrayList<>();
            String model = information[0];
            int engineSpeed = Integer.parseInt(information[1]);
            int enginePower = Integer.parseInt(information[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(information[3]);
            String cargoType = information[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            double tyre1Pressure = Double.parseDouble(information[5]);
            int tyre1Age = Integer.parseInt(information[6]);
            Tire tire1 = new Tire(tyre1Pressure, tyre1Age);
            tires.add(tire1);
            double tyre2Pressure = Double.parseDouble(information[7]);
            int tyre2Age = Integer.parseInt(information[8]);
            Tire tire2 = new Tire(tyre2Pressure, tyre2Age);
            tires.add(tire2);
            double tyre3Pressure = Double.parseDouble(information[9]);
            int tyre3Age = Integer.parseInt(information[10]);
            Tire tire3 = new Tire(tyre3Pressure, tyre3Age);
            tires.add(tire3);
            double tyre4Pressure = Double.parseDouble(information[11]);
            int tyre4Age = Integer.parseInt(information[12]);
            Tire tire4 = new Tire(tyre4Pressure, tyre4Age);
            tires.add(tire4);
            Car car = new Car(model, engine, cargo, new ArrayList<>());
            cars.add(car);
            car.setTires(tires);
        }
        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            for (Car car : cars) {
                car.toStringFragile();
            }

        } else {
            for (Car car : cars) {
                car.toStringFlamable();
            }
        }
    }
}