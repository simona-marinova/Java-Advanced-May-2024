package people;

public class Person implements Comparable <Person> {
    private String name;
    private Integer age;
    private String town;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person otherPerson) {
        int nameResult = this.name.compareTo(otherPerson.name);
        int ageResult = this.age.compareTo(otherPerson.age);
        int townResult = this.town.compareTo(otherPerson.town);

        if (nameResult != 0) {
            return nameResult;
        } else if (ageResult != 0) {
            return ageResult;
        } else {
            return townResult;
        }
    }
}