package Exam;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.function.Function;
import java.util.Map;


public class TaskOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> packagesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(packagesStack::push);
        ArrayDeque<Integer> courierQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(courierQueue::offer);
        int weight = 0;

        while (!courierQueue.isEmpty() && !packagesStack.isEmpty()) {
            int courier = courierQueue.peek();
            int packages = packagesStack.peek();
            if (courier >=packages) {
                int newCourier = courier - 2 * packages;
                if (newCourier > 0) {
                    courierQueue.poll();
                    courierQueue.offer(newCourier);
                } else if (newCourier <= 0) {
                    courierQueue.poll();
                }
                weight += packages;
                packagesStack.pop();
            } else if (courier < packages) {
                //subtract the courier's capacity from the package's weight
                int subtract = packages - courier;
                weight += courier;
                packagesStack.pop();
                packagesStack.push(subtract);
                courierQueue.poll();
            }
        }


        System.out.printf("Total weight: %d kg\n", weight);
        if (courierQueue.isEmpty() && packagesStack.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        } else if (!packagesStack.isEmpty() && courierQueue.isEmpty()) {
            //o	"Unfortunately, there are no more available couriers to deliver the
            // following packages: {package1}, {package2}, (…),{packagen}"
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            //        System.out.println(materials.toString().replace("[", "").replace("]", ""));
            List<Integer> packagesList = packagesStack.stream().collect(Collectors.toList());
            Collections.reverse(packagesList);
            System.out.printf(packagesList.toString().replace("[", "").replace("]", ""));
        } else if (!courierQueue.isEmpty() && packagesStack.isEmpty()) {
//o	"Couriers are still on duty: {couriers1}, {couriers2}, (…),{couriersn} but there are no more packages to deliver."
            System.out.print("Couriers are still on duty: ");
            System.out.printf(courierQueue.toString().replace("[", "").replace("]", ""));
            System.out.print(" but there are no more packages to deliver.");
        }


    }
}
