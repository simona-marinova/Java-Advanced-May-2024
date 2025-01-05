package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            Predicate<String> predicate = null;
            String criteria = command.split("\\s+")[2];
            if (command.contains("Length")) {
                predicate = text -> text.length() == Integer.parseInt(criteria);
            } else if (command.contains("StartsWith")) {
                predicate = text -> text.startsWith(criteria);
            } else {
                predicate = text -> text.endsWith(criteria);
            }
            if (command.contains("Remove")) {
                List<String> toRemove = new ArrayList<>();
                for (String person : people) {
                    if (predicate.test(person)) {
                        toRemove.add(person);
                    }
                }
                people.removeAll(toRemove);
            } else {
                ArrayList<String> toAdd = new ArrayList<>();
                for (String person : people) {
                    if (predicate.test(person)) {
                        toAdd.add(person);
                    }
                }
                people.addAll(toAdd);
            }
            command = scanner.nextLine();
        }

        if (!people.isEmpty()) {
            Collections.sort(people);
            System.out.print(String.join(", ", people));
            System.out.print(" are going to the party!");

        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}
