package MultidimensionalArrays;

import java.util.Scanner;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;


public class DiagonalDifference1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = fillMatrix(scanner, size);
        int primarySum = primaryDiagonalSum(matrix);
        int secondarySum = secondaryDiagonalSum(matrix);
        int result = primarySum - secondarySum;
        System.out.println(Math.abs(result));
    }

    public static int[][] fillMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = numbers;
        }
        return matrix;
    }

    public static int primaryDiagonalSum(int[][] matrix) {
        int primarySum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    primarySum += matrix[i][j];
                }
            }
        }
        return primarySum;
    }

    public static int secondaryDiagonalSum(int[][] matrix) {
        int secondarySum = 0;
        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0) {
            secondarySum += matrix[row][column];
            row--;
            column++;
        }
        return secondarySum;
    }
}
