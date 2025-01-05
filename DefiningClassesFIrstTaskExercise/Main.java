package DefiningClassesFIrstTaskExercise;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            String [] personInformation = scanner.nextLine().split("\\s+");
            String name = personInformation[0];
            int age = Integer.parseInt(personInformation[1]);
            if(age>30){
                Person person = new Person (name, age);
                //John - 48
                String info = String.format("%s - %d", name, age);
                people.add(person);
            }
        }


        people.sort(Comparator.comparing(person -> person.getName()));

        for (Person person : people) {
            System.out.printf("%s - %d\n", person.getName(), person.getAge());
        }

    }
}
