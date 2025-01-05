package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> timeQueue = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(tasksStack::push);
        String duck = "";
        Map<String, Integer> ducksMap = new HashMap<>();
        ducksMap.put("Darth Vader Ducky",0);
        ducksMap.put("Thor Ducky",0);
        ducksMap.put("Big Blue Rubber Ducky",0);
        ducksMap.put("Small Yellow Rubber Ducky",0);

        while (!timeQueue.isEmpty() && !tasksStack.isEmpty()) {
            int time = timeQueue.peek();
            int task = tasksStack.peek();
            int result = time * task;
            if (result >= 0 && result <= 60) {
                duck = "Darth Vader Ducky";
                changeTheMap(ducksMap, duck);
                changeTheStackAndTheQueue(timeQueue, tasksStack);

            } else if (result >= 61 && result <= 120) {
                duck = "Thor Ducky";
                changeTheMap(ducksMap, duck);
                changeTheStackAndTheQueue(timeQueue, tasksStack);

            } else if (result >= 121 && result <= 180) {
                duck = "Big Blue Rubber Ducky";
                changeTheMap(ducksMap, duck);
                changeTheStackAndTheQueue(timeQueue, tasksStack);

            } else if (result >= 181 && result <= 240) {
                duck = "Small Yellow Rubber Ducky";
                changeTheMap(ducksMap, duck);
                changeTheStackAndTheQueue(timeQueue, tasksStack);

            } else if (result > 240) {
                tasksStack.push(tasksStack.pop() - 2);
                timeQueue.offer(timeQueue.poll());
            }
        }


        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d\n", ducksMap.get("Darth Vader Ducky"));
        System.out.printf("Thor Ducky: %d\n", ducksMap.get("Thor Ducky"));
        System.out.printf("Big Blue Rubber Ducky: %d\n", ducksMap.get("Big Blue Rubber Ducky"));
        System.out.printf("Small Yellow Rubber Ducky: %d\n", ducksMap.get("Small Yellow Rubber Ducky"));

    }

    public static void changeTheMap(Map<String, Integer> ducksMap, String duck) {
        if (ducksMap.containsKey(duck)) {
            ducksMap.put(duck, ducksMap.get(duck) + 1);
        } else {
            ducksMap.put(duck, 1);
        }
    }

    public static void changeTheStackAndTheQueue(ArrayDeque<Integer> timeQueue, ArrayDeque<Integer> tasksStack) {
        timeQueue.poll();
        tasksStack.pop();
    }


}
