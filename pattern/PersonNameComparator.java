package pattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        int firstNameLength = first.getName().length();
        int secondNameLength = second.getName().length();
        //  int nameLengthComparingResult = firstNameLength.compareTo(secondNameLength);
        int nameLengthComparingResult = Integer.compare(firstNameLength, secondNameLength);
        if (nameLengthComparingResult== 0) {
            char firstNameSymbol = first.getName().toUpperCase().charAt(0);
            char secondNameSymbol = second.getName().toUpperCase().charAt(0);
            return Character.compare(firstNameSymbol, secondNameSymbol);
        }
        return nameLengthComparingResult;
    }
}
