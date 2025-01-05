package ExamPreparation;

import java.util.*;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        Stack<Integer> materialsStack = new Stack<>();
        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();
        int[] first = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] second = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> toys = new TreeMap<>();

        for (int i = 0; i < first.length; i++) {
            int currentNumber = first[i];
            materialsStack.push(currentNumber);
        }

        for (int i = 0; i < second.length; i++) {
            int number = second[i];
            magicQueue.add(number);
        }

        while (!materialsStack.isEmpty() && !magicQueue.isEmpty()) {
            int lastMaterial = materialsStack.peek();
            int firstMagic = magicQueue.peek();
            int multiplication = lastMaterial * firstMagic;
            switch (multiplication) {
                case 150:
                    String toy = "Doll";
                    if (toys.containsKey(toy)) {
                        toys.put(toy, toys.get(toy) + 1);
                    } else {
                        toys.put(toy, 1);
                    }
                    materialsStack.pop();
                    magicQueue.poll();
                    break;
                case 250:
                    toy = "Wooden train";
                    if (toys.containsKey(toy)) {
                        toys.put(toy, toys.get(toy) + 1);
                    } else {
                        toys.put(toy, 1);
                    }
                    materialsStack.pop();
                    magicQueue.poll();
                    break;
                case 300:
                    toy = "Teddy bear";
                    if (toys.containsKey(toy)) {
                        toys.put(toy, toys.get(toy) + 1);
                    } else {
                        toys.put(toy, 1);
                    }
                    materialsStack.pop();
                    magicQueue.poll();
                    break;
                case 400:
                    toy = "Bicycle";
                    if (toys.containsKey(toy)) {
                        toys.put(toy, toys.get(toy) + 1);
                    } else {
                        toys.put(toy, 1);
                    }
                    materialsStack.pop();
                    magicQueue.poll();
                    break;
                default:
                    if (multiplication < 0) {
                        int sum = lastMaterial + firstMagic;
                        materialsStack.pop();
                        magicQueue.poll();
                        materialsStack.push(sum);
                    } else if (multiplication > 0) {
                        // remove only the magic value and increase the material value by 15.
                        magicQueue.poll();
                        int number = materialsStack.peek() + 15;
                        materialsStack.pop();
                        materialsStack.push(number);
                        //materials.push(materials.pop() + 15);
                    }
                    //•	If the magic or material (or both) equals 0,
                    // remove it (or both) and continue crafting the presents.
                    if (lastMaterial == 0 || firstMagic == 0) {
                        if (lastMaterial == 0) {
                            materialsStack.pop();
                        }
                        if (firstMagic == 0) {
                            magicQueue.poll();
                        }
                    }
                    break;
            }
        }

//a doll and a train or a teddy bear and a bicycle.

        if (toys.containsKey("Doll") && toys.containsKey("Train") ||
                toys.containsKey("Teddy bear") && toys.containsKey("Bicycle")) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        //o	"Materials left: {material1}, {material2}, …"
        //o	"Magic left: {magicValue1}, {magicValue2}, …
        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.print(materialsStack.toString().replace("[", "").replace("]", ""));
            System.out.println();
        }

        if (!magicQueue.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.print(magicQueue.toString().replace("[", "").replace("]", ""));
            System.out.println();
        }
        for (Map.Entry<String, Integer> entry : toys.entrySet()) {
            //"{toy name}: {amount}
            String name = entry.getKey();
            int amount = entry.getValue();
            System.out.printf("%s: %d\n", name, amount);
        }
    }
}

