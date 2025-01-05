package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int m =Integer.parseInt(scanner.nextLine());
      //  numbers = numbers.reversed();
        Collections.reverse(numbers);
      //  numbers =numbers.stream().filter(n -> n%m!=0).toList();
      //

        Predicate<Integer> predicate = n ->n % m == 0;
        numbers.removeIf(predicate);
        numbers.forEach(number -> System.out.print(number+ " "));

    }
}
