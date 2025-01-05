package DefininfClassesSecondTask;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String info = scanner.nextLine();
            String [] data = info.split("\\s+");
            String brand = data[0];
          Car car;
           if(data.length==1){
               car = new Car(brand);
           }
           else {
               car = new Car(brand, data[1], Integer.parseInt(data[2]));
           }
          System.out.printf("The car is: %s %s - %d HP.\n", car.getBrand(), car.getModel(), car.getHorsePower());

        }


    }
}
