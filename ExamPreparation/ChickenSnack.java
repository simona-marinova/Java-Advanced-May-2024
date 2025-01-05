package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.function.Function;


public class ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    ArrayDeque<Integer>  moneyStack = new ArrayDeque<>();
            Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(moneyStack::push);

        ArrayDeque<Integer> pricesQueue = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        int numberOfFoods =0;
        boolean isEaten = true;

        while(!moneyStack.isEmpty()&& !pricesQueue.isEmpty()){
            int money = moneyStack.peek();
            int price = pricesQueue.peek();
            if(money==price){
                numberOfFoods++;
                moneyStack.pop();
                pricesQueue.poll();
            }
            else if(money>price){
                numberOfFoods++;
                int change = money-price;
                if(moneyStack.size()>1){
                    moneyStack.pop();
                moneyStack.push(moneyStack.pop()+change);}
                pricesQueue.poll();
            }
            else {
                isEaten=false;
                moneyStack.pop();
                pricesQueue.poll();
            }
        }

        if(numberOfFoods>=4){
            System.out.printf("Gluttony of the day! Henry ate %d foods.", numberOfFoods);
        }
        else if(numberOfFoods>1 && !isEaten){
            System.out.printf("Henry ate: %d foods.", numberOfFoods);
        }
        else if(numberOfFoods==1){
            System.out.printf("Henry ate: %d food.", numberOfFoods);
        }
        else if(numberOfFoods==0){
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }

    }
}
