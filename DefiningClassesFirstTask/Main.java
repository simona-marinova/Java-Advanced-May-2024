package DefiningClassesFirstTask;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //Car car2 = new Car();
        //отделните инстанции имат отделно състояние, полета

        //   car.brand = "Chevrolet";
        // това означава че променяме състоянието на колата
        //  car.model = "Impala";
        //  car.horsePower =390;

        //може да зададем втори път car.brand = "Jigula"; и така колата ще стане Jigula
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String [] info = scanner.nextLine().split("\\s+");
            String brand = info[0];
            String model = info[1];
            int horsePower = Integer.parseInt(info[2]);
           // car.setBrand(brand);
           // car.setModel(model);
          //  car.setHorsePower(horsePower);
            Car car = new Car(brand, model, horsePower);
            System.out.println(car.getInfo());

        }

       // car.setBrand("Chevrolet");
       // car.setModel("Impala");
      //  car.setHorsePower(390);


    }
}
