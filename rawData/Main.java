package rawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            //"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure}
            // {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure}
            // {Tire4Age}", where the speed, power, weight and tire age are integers, tire pressure is a double.
            //ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
            String[] info = scanner.nextLine().split(" ");
            String model = info[0];
            int speed = Integer.parseInt(info[1]);
            int power = Integer.parseInt(info[2]);
            Engine engine = new Engine(speed, power);
            int weight = Integer.parseInt(info[3]);
            String type = info[4];
            Cargo cargo = new Cargo(weight, type);
            List<Tire> tiresList = new ArrayList<>();
            for (int j = 5; j < info.length; j += 2) {
                double pressure = Double.parseDouble(info[j]);
                int age = Integer.parseInt(info[j + 1]);
                Tire tire = new Tire(pressure, age);
                tiresList.add(tire);
            }
            Car car = new Car(model, engine, cargo, tiresList);
            cars.add(car);
        }
        String command = scanner.nextLine();
        //if the command is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is
        // < 1 if the command is "flamable" print all cars whose Cargo Type is "flamable" and have Engine Power > 250.
        // The cars should be printed in order of appearing in the input.
        if(command.equals("fragile")) {
            cars = cars.stream().filter(car -> car.getCargo().getType().equals("fragile")).collect(Collectors.toList());
            //with a tire whose pressure is  < 1
            for (Car car : cars) {
                for (Tire tire : car.getTires()) {
                    if (tire.getPressure() < 1) {
                        System.out.println(car);
                        break;
                    }
                }
            }
        }
        else {
                cars = cars.stream().filter(car->car.getCargo().getType().equals("flamable")).collect(Collectors.toList());
            for (Car car : cars) {
                if(car.getEngine().getPower()>250){
                    System.out.println(car);
                }
            }
        }



    }
}
