package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> foodPortionsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(foodPortionsStack::push);
        ArrayDeque<Integer> dailyStaminaQueue = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<String> peaksQueue = new ArrayDeque<>();
        peaksQueue.offer("Vihren");
        peaksQueue.offer("Kutelo");
        peaksQueue.offer("Banski Suhodol");
        peaksQueue.offer("Polezhan");
        peaksQueue.offer("Kamenitza");
        ArrayDeque<Integer> difficultyQueue = new ArrayDeque<>();
        difficultyQueue.offer(80);
        difficultyQueue.offer(90);
        difficultyQueue.offer(100);
        difficultyQueue.offer(60);
        difficultyQueue.offer(70);

        int day = 0;

        List<String> climbedPeaks = new ArrayList<>();

        while (day++ <= 7) {
            String peak = peaksQueue.peek();
            int difficulty = difficultyQueue.peek();
            int food = foodPortionsStack.peek();
            int stamina = dailyStaminaQueue.peek();
            int sum = food + stamina;
            if (sum >= difficulty) {
                foodPortionsStack.pop();
                dailyStaminaQueue.poll();
                climbedPeaks.add(peak);
                peaksQueue.poll();
                difficultyQueue.poll();
                if (peaksQueue.isEmpty() || foodPortionsStack.isEmpty()) {
                    break;
                }
            } else {
                foodPortionsStack.pop();
                dailyStaminaQueue.poll();
                if(foodPortionsStack.isEmpty()){
                    break;
                }
            }

        }
        if (peaksQueue.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if(!climbedPeaks.isEmpty()){
            System.out.println("Conquered peaks:");
            for (String climbedPeak : climbedPeaks) {
                System.out.println(climbedPeak);
            }
        }
    }
}
