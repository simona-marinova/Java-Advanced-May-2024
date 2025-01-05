package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> divisors = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
      List<Predicate<Integer>> predicates = new ArrayList<>();

        for (Integer divisor : divisors) {
           Predicate <Integer> predicate = number -> number%divisor==0;
           predicates.add(predicate);
        }
      
        for (int i = 1; i <=n; i++) {
            boolean isDivisible =true;
            for (Predicate<Integer> predicate : predicates) {
                if(!predicate.test(i)){
                    isDivisible=false;
                }
            }
            if(isDivisible){
                System.out.print(i + " ");
            }
        }



    }
}
