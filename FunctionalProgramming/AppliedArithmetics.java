package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.function.Function;


public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Function <List <Integer>, List<Integer>> add = list -> list.stream().map(n ->n+1).collect(Collectors.toList());
        Function <List <Integer>, List<Integer>> multiply = list -> list.stream().map(n->n*2).collect(Collectors.toList());
        Function  <List <Integer>, List<Integer>> subtract = list -> list.stream().map(n->n-1).collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> System.out.println(list.toString().replace("[", "").replace("]", "").replace("," , ""));

        String command = scanner.nextLine();

        while (!command.equals("end")){
            switch(command){
                case "add":
                  numbers = add.apply(numbers);
                    break;
                case "multiply":
                  numbers= multiply.apply(numbers);
                    break;
                case "subtract":
                  numbers =subtract.apply(numbers);
                    break;
                case "print":
                  print.accept(numbers);
                    break;
            }
            command =scanner.nextLine();

        }

    }
}
