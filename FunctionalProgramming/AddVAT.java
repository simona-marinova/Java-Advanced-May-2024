package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        List<Double> arrayList = Arrays.stream(text.split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());
        Function<Double, Double> priceWithVat = price -> price*1.2;
        System.out.println("Prices with VAT:");
        for (Double v : arrayList) {
            System.out.printf("%.2f\n", priceWithVat.apply(v));
        }

    }
}
