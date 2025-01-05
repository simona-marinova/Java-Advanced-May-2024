package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;


public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //There will be given two sequences of integers, representing tools and
        // substances that he has at his disposal. There will also be a third sequence of integers
        // , representing all challenges in the temple.

        ArrayDeque<Integer> toolsQueue = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(substancesStack::push);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> challenges = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            challenges.add(numbers[i]);
        }


        while (!substancesStack.isEmpty()&& !toolsQueue.isEmpty()) {
            int tool = toolsQueue.peek();
            int substance = substancesStack.peek();
            int result = tool * substance;
            boolean isEqual = false;
            for (Integer challenge : challenges) {
                if (result == challenge) {
                    toolsQueue.poll();
                    substancesStack.pop();
                    challenges.remove(Integer.valueOf(result));
                    isEqual = true;
                    break;
                }
            }
            if (!isEqual) {
                //o	Increase the value of the tool element by 1 and move the element to the back of the tools’ sequence.
                tool++;
                toolsQueue.poll();
                toolsQueue.offer(tool);
                //o	Decrease the value of the substance element by 1 and return the element to the substance’s sequence.
                // If the value of the substance element reaches 0, remove it from the sequence.
                substancesStack.push(substancesStack.pop() - 1);
                if (substancesStack.peek() == 0) {
                    substancesStack.pop();
                }

            }

        }
        if (challenges.size() >= 1) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }
        if (!toolsQueue.isEmpty()) {
            System.out.print("Tools: ");
            System.out.print(toolsQueue.toString().replace("[", "").replace("]", ""));
            System.out.println();
        }
        if (!substancesStack.isEmpty()) {
            List<Integer> stackList = substancesStack.stream().toList();
            System.out.print("Substances: ");
            System.out.print(stackList.reversed().toString().replace("[", "").replace("]", ""));
            System.out.println();

        }
        if (!challenges.isEmpty()) {
            System.out.print("Challenges: ");
            System.out.print(challenges.toString().replace("[", "").replace("]", ""));
        }
    }
}

