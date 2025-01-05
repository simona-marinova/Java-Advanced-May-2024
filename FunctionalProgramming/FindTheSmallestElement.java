package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
        .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> function = numbs -> {
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i <numbs.size(); i++) {
                if (numbs.get(i) < minValue) {
                    minValue = numbs.get(i);

                }
            }
            return minValue;
        };

        System.out.println(numbers.lastIndexOf(function.apply(numbers)));
    }
}
