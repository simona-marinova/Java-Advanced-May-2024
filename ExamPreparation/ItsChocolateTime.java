package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(milkQueue::offer);
        ArrayDeque<Double> cacaoPowderStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(cacaoPowderStack::push);
        Map<String, Integer> chocolates = new TreeMap<>();


        while (!milkQueue.isEmpty() && !cacaoPowderStack.isEmpty()) {
            double milk = milkQueue.peek();
            double cacao = cacaoPowderStack.peek();
            double cacaoPercentage = (cacao / (milk + cacao))*100;
            if (cacaoPercentage == 30) {
                if (chocolates.containsKey("Milk Chocolate")) {
                    chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
                } else {
                    chocolates.put("Milk Chocolate", 1);
                }
                cacaoPowderStack.pop();
                milkQueue.poll();
            } else if (cacaoPercentage == 50) {
                if (chocolates.containsKey("Dark Chocolate")) {
                    chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
                } else {
                    chocolates.put("Dark Chocolate", 1);
                }
                cacaoPowderStack.pop();
                milkQueue.poll();
            } else if (cacaoPercentage == 100) {
                if (chocolates.containsKey("Baking Chocolate")) {
                    chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
                } else {
                    chocolates.put("Baking Chocolate", 1);
                }
                cacaoPowderStack.pop();
                milkQueue.poll();
            } else {
                cacaoPowderStack.pop();
                milkQueue.offer(milkQueue.poll() + 10);
            }

        }

        boolean success = chocolates.containsKey("Milk Chocolate") && chocolates.containsKey("Baking Chocolate")
                && chocolates.containsKey("Dark Chocolate");
        if (success) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }
        else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for (Map.Entry<String, Integer> entry : chocolates.entrySet()) {
            //# {chocolate type} --> {amount}".
            System.out.printf("# %s --> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
