package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(steelQueue::offer);
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(carbonStack::push);
        Map<String, Integer> swords = new TreeMap<>();

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();
            int sum = steel + carbon;
            switch (sum) {
                case 70:
                    if (swords.containsKey("Gladius")) {
                        swords.put("Gladius", swords.get("Gladius") + 1);
                    } else {
                        swords.put("Gladius", 1);
                    }
                    break;
                case 80:
                    if (swords.containsKey("Shamshir")) {
                        swords.put("Shamshir", swords.get("Shamshir") + 1);
                    } else {
                        swords.put("Shamshir", 1);
                    }
                    break;
                case 90:
                    if (swords.containsKey("Katana")) {
                        swords.put("Katana", swords.get("Katana") + 1);
                    } else {
                        swords.put("Katana", 1);
                    }
                    break;
                case 110:
                    if (swords.containsKey("Sabre")) {
                        swords.put("Sabre", swords.get("Sabre") + 1);
                    } else {
                        swords.put("Sabre", 1);
                    }
                    break;
                default:
                    int increasedCarbon = carbon + 5;
                    carbonStack.push(increasedCarbon);
                    break;
            }


        }

        int countOfSwords =0;
        for (Map.Entry<String, Integer> entry : swords.entrySet()) {
            countOfSwords+= entry.getValue();
        }


        if(!swords.isEmpty()){
            System.out.printf("You have forged %d swords.\n", countOfSwords );
        }
        else {
            System.out.println("You did not have enough resources to forge a sword." );
        }
        if(steelQueue.isEmpty()){
            System.out.println("Steel left: none");
        }
        else {
            System.out.print("Steel left: ");
            System.out.print(steelQueue.toString().replace("[", "").replace("]", ""));
            System.out.println();
        }
        if(carbonStack.isEmpty()){
            System.out.println("Carbon left: none");
        }
        else {
            System.out.print("Carbon left: ");
            System.out.print(carbonStack.toString().replace("[", "").replace("]", ""));
            System.out.println();
        }

        for (Map.Entry<String, Integer> entry : swords.entrySet()) {
//"Sabre: {amount}"
//"Katana: {amount}"
//"Shamshir: {amount}"
//"Gladius: {amount}"
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());

        }
    }


}
