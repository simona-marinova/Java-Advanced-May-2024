package ExamPreparation;

import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.function.Function;


public class PiePursuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //queue
        ArrayDeque<Integer> contestants = new ArrayDeque<>();
        //stack
        ArrayDeque<Integer> pies = new ArrayDeque<>();

        for (int i = 0; i < firstRow.length; i++) {
            contestants.add(firstRow[i]);
        }

        for (int i = 0; i < secondRow.length; i++) {
            pies.push(secondRow[i]);
        }

        while (!contestants.isEmpty() && !pies.isEmpty()) {
            int contestant = contestants.peek();
            int pie = pies.peek();
            if (contestant >= pie) {
                pies.pop();
                if (contestant - pie == 0) {
                    contestants.poll();
                } else {
                    contestants.add(contestants.poll() - pie);
                }
            } else {
                pies.push(pies.pop() - contestant);
                contestants.poll();
                if (pies.peek() == 1 && pies.size() > 1) {
                    pies.pop();
                    pies.push(pies.pop() + 1);
                }
            }
        }

     List <Integer> piesList = new ArrayList<>();
        for (Integer pie : pies) {
            piesList.add(pie);
        }


        if (contestants.size() > 0 && pies.isEmpty()) {
            System.out.println("We will have to wait for more pies to be baked!");
            System.out.print("Contestants left: ");
            System.out.print(contestants.toString().replace("[", "").replace("]", ""));
            System.out.println();
        } else if (pies.isEmpty()) {
            System.out.println("We have a champion!");
        } else {
            System.out.println("Our contestants need to rest!");
            System.out.print("Pies left: ");
            System.out.print(piesList.reversed().toString().replace("[", "").replace("]", ""));
            System.out.println();
        }

    }
}