package opinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split(" ");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            Person person = new Person(name, age);
            people.add(person);
        }
        Collections.sort(people, Comparator.comparing(person -> person.getName()));
        people.stream().filter(person->person.getAge()>30).forEach(person-> System.out.println(person.toString()));

    }
}
