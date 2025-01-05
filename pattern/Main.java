package pattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person> firstSet = new TreeSet<>(new PersonAgeComparator());
        TreeSet<Person> secondSet = new TreeSet<>(new PersonNameComparator());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String [] info = scanner.nextLine().split(" ");
            String name = info [0];
            Integer age = Integer.parseInt(info[1]);
            Person person = new Person (name, age);
            firstSet.add(person);
            secondSet.add(person);
        }

        secondSet.forEach(person-> System.out.println(person));
        firstSet.forEach(person-> System.out.println(person));
    }
}
