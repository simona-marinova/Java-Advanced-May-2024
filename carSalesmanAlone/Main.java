package carSalesmanAlone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split(" ");
            //"{Model} {Power} {Displacement} {Efficiency}".
            //V8-101 220 50
            //V4-33 140 28 B
            String model = info[0];
            String power = info[1];
            String displacement = "n/a";
            String efficiency = "n/a";
            if (info.length == 4) {
                displacement = info[2];
                efficiency = info[3];
            } else if (info.length == 3) {
                char firstChar = info[2].charAt(0);
                if (Character.isLetter(firstChar)) {
                    efficiency = info[2];
                } else {
                    displacement = info[2];
                }
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            //"{Model} {Engine} {Weight} {Color}",
            String[] info = scanner.nextLine().split(" ");
            String model = info[0];
            String engineName = info[1];
            String weight = "n/a";
            String color = "n/a";
            if (info.length == 4) {
                weight = info[2];
                color = info[3];
            } else if (info.length == 3) {
                char first = info[2].charAt(0);
                if (Character.isDigit(first)) {
                    weight = info[2];
                } else {
                    color = info[2];
                }
            }
            Engine engine = getEngineByModel(engineName, engines);
            Car car = new Car(model, engine, weight, color);
            cars.add(car);
        }
        cars.forEach(car-> System.out.print(car));

    }

    public static Engine getEngineByModel(String model, List<Engine> engines) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(model)) {
                return engine;
            }
        }
        return null;
    }
}
