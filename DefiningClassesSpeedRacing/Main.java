package DefiningClassesSpeedRacing;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            //Model} {FuelAmount} {FuelCostFor1km}", all cars start at 0 kilometers traveled.
            String [] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
           double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelCostOneKm = Double.parseDouble(carInfo[2]);
            Car car = new Car(model, fuelAmount, fuelCostOneKm);
            cars.add(car);
        }
        //Drive {CarModel} {amountOfKm}",
        String instruction = scanner.nextLine();

        while(!instruction.equals("End")){
            String [] commands = instruction.split("\\s+");
            String carModel = commands[1];
           int amountOfKm = Integer.parseInt(commands[2]);
           Car car = getCarByName(cars, carModel);
car.drive(amountOfKm);
            instruction=scanner.nextLine();
        }

//After the "End" command is received, print each car in order of
// appearing in input, and its current fuel amount and distance traveled in the format
// "{Model} {fuelAmount} {distanceTraveled}",
// where the fuel amount should be printed to two decimal places after the separator.
        for (Car car : cars) {
            System.out.println(car.toString());
        }


    }

    private static Car getCarByName(List<Car> cars, String carModel) {
        for (Car car : cars) {
            if(carModel.equals(car.getModel())){
                return car;
            }
        }
        return null;
    }
}
