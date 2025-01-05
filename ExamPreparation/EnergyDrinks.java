package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(caffeineStack::push);
        ArrayDeque<Integer> energyDrinksQueue = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int caffeineSum = 0; //max 300

        while (!energyDrinksQueue.isEmpty() && !caffeineStack.isEmpty()) {
            int caffeine = caffeineStack.peek();
            int energyDrink = energyDrinksQueue.peek();
            int result = caffeine * energyDrink;
            if (caffeineSum + result <= 300) {
                caffeineSum += result;
                energyDrinksQueue.poll();
                caffeineStack.pop();
            } else {
                caffeineStack.pop();
                energyDrinksQueue.offer(energyDrinksQueue.poll());
                caffeineSum -= 30;
                if (caffeineSum < 0) {
                    caffeineSum = 0;
                }
            }

        }

        if (energyDrinksQueue.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            //	"Drinks left: { remaining drinks separated by ", " }"
            System.out.print("Drinks left: ");
            System.out.print(energyDrinksQueue.toString().replace("[", "").replace("]", ""));
            System.out.println();
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", caffeineSum);

    }
}
