package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
       List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
   //   int sum= numbers.stream().mapToInt(Integer::valueOf).sum();
     //   System.out.println("Count = " +numbers.size());
    //    System.out.println("Sum = "+ sum);

    
Function<List<Integer>, Integer> listSum = list -> {
        int sumTwo =0;
        for (Integer number : numbers) {
            sumTwo+=number;
        }
        return sumTwo;
};

int sum = listSum.apply(numbers);

        System.out.println("Count = " +numbers.size());
         System.out.println("Sum = "+ sum);




    }
}
