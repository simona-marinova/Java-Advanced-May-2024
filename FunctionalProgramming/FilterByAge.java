package FunctionalProgramming;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] pairs = scanner.nextLine().split(", ");
            String name = pairs[0];
            int age = Integer.parseInt(pairs[1]); //x
            people.put(name, age);
        }


        //•	Condition - "younger" or "older"
        String condition = scanner.nextLine();
        int ageFromConsole = Integer.parseInt(scanner.nextLine()); //y
        //•	Format - "name", "age" or "name age"
        String format = scanner.nextLine();

        BiPredicate<Integer, Integer> filterByAge;
        if (condition.equals("younger")) {
            filterByAge = (x, y) -> x <= y;
        } else {
            filterByAge = (x, y) -> x >= y;
        }

        Consumer<Map.Entry<String, Integer>> print;
        if (format.equals("name")) {
            print = person -> System.out.println(person.getKey());
        } else if (format.equals("age")) {
            print = person -> System.out.println(person.getValue());
        } else {
            print = person -> System.out.printf("%s - %d\n", person.getKey(), person.getValue());
        }
        people.entrySet().stream()
                .filter(person -> filterByAge.test(person.getValue(), ageFromConsole))
                .forEach(print);
    }
}