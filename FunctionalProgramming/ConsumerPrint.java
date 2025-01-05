package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;



public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] names = scanner.nextLine().split(" ");

        //   Consumer<String> printNames = name -> System.out.println(name);

        //  for (int i = 0; i <names.length ; i++) {
        //  printNames.accept(names[i]);
        //    }

      Arrays.stream(names).forEach(name -> System.out.println(name));
    }
}
