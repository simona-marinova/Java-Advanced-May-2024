package ExamPreparation;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.function.Function;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //initialFuel - the last fuel quantity
        //additional consumption index - the first index from the additional consumption index sequence
        //amount of fuel needed

        ArrayDeque<Integer> fuelStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(fuelStack::push);
        ArrayDeque<Integer> additionalConsumptionIndexQueue = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> neededAmountQueue = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        List<String> altitudes = new ArrayList<>();
        boolean notEnoughFuel = false;
        int numberReachedAltitudes =0;

        while (!notEnoughFuel && !fuelStack.isEmpty()) {
            int fuel = fuelStack.peek();
            int index = additionalConsumptionIndexQueue.peek();
            int result = fuel - index;
            int neededAmount = neededAmountQueue.peek();
            if (result >= neededAmount) {
                numberReachedAltitudes++;
                System.out.printf("John has reached: Altitude %d\n", numberReachedAltitudes);
                String text = String.format("Altitude %d", numberReachedAltitudes);
                altitudes.add(text);
                fuelStack.pop();
                additionalConsumptionIndexQueue.poll();
                neededAmountQueue.poll();
                if(neededAmountQueue.size()==0){
                    System.out.println("John has reached all the altitudes and managed to reach the top!");
                    return;
                }
            } else {
                notEnoughFuel = true;
                System.out.printf("John did not reach: Altitude %d\n", numberReachedAltitudes+1);
            }
        }

        if (altitudes.size() >= 1 && notEnoughFuel) {
            System.out.println("John failed to reach the top.");
                System.out.print("Reached altitudes: ");
                 System.out.println(altitudes.toString().replace("[", "").replace("]", ""));

        }
        else if(notEnoughFuel && altitudes.isEmpty()) {
            System.out.println("John failed to reach the top.");
            System.out.println("John didn't reach any altitude.");
        }


    }
}