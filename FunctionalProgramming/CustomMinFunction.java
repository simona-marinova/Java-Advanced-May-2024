package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.List;


public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> function =list -> Collections.min(numbers);
        System.out.println(function.apply(numbers));
    }

}
