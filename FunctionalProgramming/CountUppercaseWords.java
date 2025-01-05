package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(" ");
        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));
        int count =0;
        for (String s : text) {
            if(isUpperCase.test(s)){
                count++;
            }
        }
        System.out.println(count);
        for (String s : text) {
            if (isUpperCase.test(s)) {
                System.out.println(s);
            }
        }


    }
}
