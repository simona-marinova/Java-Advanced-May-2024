package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

      //  names.forEach(name -> System.out.println("Sir " + name));

        Function<String, String> function = name -> "Sir " + name;

        names.stream().map(function).forEach(name -> System.out.println(name));


    }
}
