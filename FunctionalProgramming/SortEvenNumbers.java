package FunctionalProgramming;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;


public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(number -> Integer.parseInt(number)).collect(Collectors.toList());
       // List<Integer> numbersTwo = Arrays.stream(scanner.nextLine().split(", "))
             //   .map(Integer::parseInt).collect(Collectors.toList());
        // scanner.nextLine(). - вземаме първия ред от конзолата
        // split(", ") - сплитваме по , и интервал
        // така получаваме масив върху който ще пуснем stream - Arrays.stream
        //.map - вземаме едновременно всеки един от елементите
        //всяко число в този масив ще искам да ми се парсне в цяло число и
        //след това ще го направя в лист
        // даваме - import java.util.stream.Collectors;
        //stream-а започва преди scanner и приключва след split
       // .map(number -> Integer.parseInt(number)) - може да се замени с метод reference -
        // .map(Integer::parseInt) - тези четири точки :: означават че приемаме един аргумент и този
        //аргумент го подаваме на този метод - parseInt.

       // List <Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

        numbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        printListWithComma(numbers);

//numbers.forEach(number -> System.out.print(number));

      //  numbers.forEach(n -> System.out.print(n + " "));
     //   System.out.println();
        Collections.sort(numbers);

     //   numbers.forEach(n -> System.out.print(n + " "));

       // List<Integer> numbersTwo = Arrays.stream(scanner.nextLine().split(", "))
               // .map(number -> Integer.parseInt(number))
              //  .filter(n -> n % 2 == 0)
               // .collect(Collectors.toList());

      
        printListWithComma(numbers);

    }

    public static void printListWithComma (List<Integer> numbers){
     List <String> numbersAsText = new ArrayList<>();
        for (Integer number : numbers) {
numbersAsText.add(String.valueOf(number));
        }
        System.out.println(String.join(", ", numbersAsText));
    }

}
