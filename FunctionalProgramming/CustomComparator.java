package FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = (numberOne, numberTwo) -> {
            if (numberOne % 2 == 0 && numberTwo % 2 != 0) {
                return -1;
            }
            if (numberOne % 2 != 0 && numberTwo % 2 == 0) {
           return 1;
            }
            return numberOne.compareTo(numberTwo);
        };
numbers.stream().sorted(comparator).forEach(number -> System.out.print(number + " "));
    }
}
