package MultidimensionalArrays;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        List<Integer> firstDiagonal = new ArrayList<>();
        List<Integer> secondDiagonal = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = numbers;
        }

        int currentElement = matrix[0][0];
        firstDiagonal.add(currentElement);

        for (int i = 1; i < n; i++) {
            int nextElement = matrix[i][i];
            firstDiagonal.add(nextElement);
        }
//currentElement = matrix[matrix.length-1][0];
       // secondDiagonal.add(currentElement);

     //   for (int i = 1; i <n ; i++) {
       //     int nextElement = matrix[matrix.length-1-i][i];
      //      secondDiagonal.add(nextElement);
     //   }

        int row = matrix.length -1;
        int col = 0;

        while(row>=0 && col<= matrix.length-1){
            secondDiagonal.add(matrix[row][col]);
            row--;
            col++;
        }

        for (int number:firstDiagonal) {
            System.out.print(number + " ");
        }
        System.out.println();

        for (int number:secondDiagonal) {
            System.out.print(number + " ");
        }

    }
}

