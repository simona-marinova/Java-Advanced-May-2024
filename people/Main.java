package people;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        int totalPeople = 0;

        while (!info.equals("END")) {
            String[] information = info.split(" ");
            String name = information[0];
            int age = Integer.parseInt(information[1]);
            String town = information[2];
            Person person = new Person(name, age, town);
            totalPeople++;
            people.add(person);
            info = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());
        Person personToCompare = people.get(n - 1);
        people.remove(personToCompare);
        int equalPeople = 0;
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).compareTo(personToCompare) == 0) {
                equalPeople++;
            }
        }
        if (equalPeople == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equalPeople + 1, people.size() - equalPeople, totalPeople);

        }
    }

}