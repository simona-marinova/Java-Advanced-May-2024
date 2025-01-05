package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> armorQueue = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> strikesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).forEach(strikesStack::push);
        int killedMonsters = 0;

        while (!armorQueue.isEmpty() && !strikesStack.isEmpty()) {
            int armor = armorQueue.peek();
            int strike = strikesStack.peek();
            if (strike >= armor) {
                killedMonsters++;
                int result = strike - armor;
                if (strikesStack.size() > 1 && result > 0) {
                    armorQueue.poll();
                    strikesStack.pop();
                    strikesStack.push(strikesStack.pop() + result);
                } else if (result == 0) {
                    armorQueue.poll();
                    strikesStack.pop();
                }
                else if(result>0 && strikesStack.size()==1){
                    strikesStack.push(strikesStack.pop()-armorQueue.peek());
                    armorQueue.poll();
                }
            } else {
                armorQueue.offer(armorQueue.poll() - strike);
                strikesStack.pop();
            }
        }

        if (armorQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (strikesStack.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", killedMonsters);
    }
}
