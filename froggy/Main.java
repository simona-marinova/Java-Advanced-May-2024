package froggy;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1, 2, 3, 4, 5, 6, 7, 8
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lake lake = new Lake(numbers);

        List<String> output = new ArrayList<>();
        for (Integer number : lake) {
            output.add(number.toString());
        }

        System.out.println(String.join(", ", output));
    }
}
