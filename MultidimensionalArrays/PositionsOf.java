package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int arrays = array[0];
        int elements = array[1];
        int[][] matrix = new int[arrays][elements];

        for (int i = 0; i < arrays; i++) {
            int[] currentArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = currentArray;
        }
        int number = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            int[] currentArray = matrix[i];
            for (int j = 0; j < currentArray.length; j++) {
                int currentNumber = currentArray[j];
                if (currentNumber == number) {
                    count++;
                    System.out.printf("%d %d", i, j);
                    System.out.println();
                }
            }
        }
        if (count == 0) {
            System.out.println("not found");
        }
    }
}
