package ExamPreparation;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.Arrays;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;


public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> textileQueue = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> medicamentsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(medicamentsStack::push);

        Map<String, Integer> itemsMap = new TreeMap<>();
        itemsMap.put("Patch", 0);
        itemsMap.put("Bandage", 0);
        itemsMap.put("MedKit", 0);

        while (!textileQueue.isEmpty() && !medicamentsStack.isEmpty()) {
            int textile = textileQueue.peek();
            int medicament = medicamentsStack.peek();
            int sum = textile + medicament;
            String item = "";
            if (sum == 30) {
                item = "Patch";
                changeTheMap(item, itemsMap);
                changeTheQueueAndTheStack(textileQueue, medicamentsStack);
            } else if (sum == 40) {
                item = "Bandage";
                changeTheMap(item, itemsMap);
                changeTheQueueAndTheStack(textileQueue, medicamentsStack);
            } else if (sum == 100) {
                item = "MedKit";
                changeTheMap(item, itemsMap);
                changeTheQueueAndTheStack(textileQueue, medicamentsStack);
            } else if (sum > 100) {
                item = "MedKit";
                int numberToAdd = sum - 100;
                changeTheMap(item, itemsMap);
                changeTheQueueAndTheStack(textileQueue, medicamentsStack);
                medicamentsStack.push(medicamentsStack.pop() + numberToAdd);
            } else {
                textileQueue.poll();
                medicamentsStack.push(medicamentsStack.pop() + 10);
            }
        }

        if (textileQueue.isEmpty() && medicamentsStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textileQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (medicamentsStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }


        itemsMap = itemsMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));


        for (Map.Entry<String, Integer> entry : itemsMap.entrySet()) {
            //{item name} - {amount created}
            if(entry.getValue()!=0){
                System.out.printf("%s - %d\n", entry.getKey(), entry.getValue());}
        }

        if (!medicamentsStack.isEmpty()) {
            System.out.print("Medicaments left: ");
            System.out.println(medicamentsStack.toString().replace("[", "").replace("]", ""));
        }


        if (!textileQueue.isEmpty()) {
            System.out.print("Textiles left: ");
            System.out.println(textileQueue.toString().replace("[", "").replace("]", ""));

        }
    }


    public static void changeTheMap(String item, Map<String, Integer> itemsMap) {
        itemsMap.put(item, itemsMap.get(item) + 1);
    }

    public static void changeTheQueueAndTheStack(ArrayDeque<Integer> textileQueue, ArrayDeque<Integer> medicamentsStack) {
        textileQueue.poll();
        medicamentsStack.pop();
    }

}



