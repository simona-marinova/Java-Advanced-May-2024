package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int lowerBound = array[0];
        int upperBound = array[1];
        String command = scanner.nextLine();
        Predicate<Integer> isEven = number -> number%2==0;
                switch(command){
                    case "even":
                        for (int i = lowerBound; i <=upperBound; i++) {
                            if(isEven.test(i)){
                                System.out.print(i+ " ");
                            }
                        }
                        break;
                    case "odd":
                        for (int i = lowerBound; i <=upperBound; i++) {
                            if(!isEven.test(i)){
                                System.out.print(i + " ");
                            }
                        }
                        break;
                }
    }

    }
