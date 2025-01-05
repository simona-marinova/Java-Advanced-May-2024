package ExamPreparation;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;


public class WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> wormsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(wormsStack::push);
        ArrayDeque<Integer> holesQueue = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;
        int numberOfWorms = wormsStack.size();
        while (!wormsStack.isEmpty() && !holesQueue.isEmpty()) {
            int worm = wormsStack.peek();
            int hole = holesQueue.peek();
            if (worm == hole) {
                wormsStack.pop();
                holesQueue.poll();
                matches++;
            } else {
                holesQueue.poll();
                wormsStack.push(wormsStack.pop() - 3);
                if (wormsStack.peek() <= 0) {
                    wormsStack.pop();
                }
            }

        }
        List <Integer> wormsList = wormsStack.stream().toList();
        if (matches > 0) {
            System.out.printf("Matches: %d\n", matches);
        } else {
            System.out.println("There are no matches.");
        }

        if (numberOfWorms == matches) {
            System.out.println("Every worm found a suitable hole!");
        } else if (wormsStack.isEmpty() && matches < numberOfWorms) {
            System.out.println("Worms left: none");
        } else if (!wormsStack.isEmpty()) {
            System.out.print("Worms left: ");
            System.out.print(wormsList.reversed().toString().replace("[","").replace("]", ""));
            System.out.println();
        }

        if(holesQueue.isEmpty()){
            System.out.println("Holes left: none");
        }
   else {
            System.out.print("Holes left: ");
            System.out.print(holesQueue.toString().replace("[","").replace("]", ""));
        }
    }
}
