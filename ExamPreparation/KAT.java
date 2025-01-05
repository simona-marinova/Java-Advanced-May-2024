package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ArrayDeque<Integer> licensePlatesQueue = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
      //  ArrayDeque<Integer> carsStack = new ArrayDeque<>();
      //  Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(carsStack::push);
        ArrayDeque<Integer> licensePlatesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(licensePlatesQueue::offer);
        ArrayDeque<Integer> carsStack = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(carsStack::push);
        int registeredCars = 0;
        int days = 0;

        while (!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {
            days++;
            int license = licensePlatesQueue.peek();
            int car = carsStack.peek();
            int neededLicensePlates = 2 * car;
            if (neededLicensePlates == license) {
                registeredCars += car;
                carsStack.pop();
                licensePlatesQueue.poll();
            } else if (neededLicensePlates > license) {
                int carsToRegister = license / 2;
                registeredCars += carsToRegister;
                int carsToWait = car - carsToRegister;
                carsStack.pop();
                carsStack.offer(carsToWait);
                licensePlatesQueue.poll();
            } else {
                registeredCars += car;
                int licencePlatesToMove = license - car * 2;
                carsStack.pop();
                licensePlatesQueue.poll();
                licensePlatesQueue.offer(licencePlatesToMove);
            }
        }

        System.out.printf("%s cars were registered for %d days!\n", registeredCars, days);
        if (!licensePlatesQueue.isEmpty()) {
            int sum =0;
            for (Integer i : licensePlatesQueue) {
                sum+=i;
            }
            System.out.printf("%d license plates remain!\n",sum);
        }
        if (!carsStack.isEmpty()) {
            int carsWithoutLicensePlates =0;
            for (Integer i : licensePlatesQueue) {
                carsWithoutLicensePlates+=i;
            }
            System.out.printf("%d cars remain without license plates!\n",carsWithoutLicensePlates);
        }
        if (carsStack.isEmpty() && licensePlatesQueue.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }

}

