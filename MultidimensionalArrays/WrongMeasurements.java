package MultidimensionalArrays;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = numbers;
        }

        int [][] newMatrix = new int[rows][matrix[0].length];
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstValue = numbers[0];
        int secondValue = numbers[1];
        int wrongValue = matrix[firstValue][secondValue];


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int sum = 0;
                int top = 0;
                int bottom = 0;
                int right = 0;
                int left = 0;
                int currentNumber = matrix[i][j];
                if (currentNumber == wrongValue) {
                    if (i - 1 >= 0 && i - 1 <= matrix.length - 1) {
                        top = matrix[i - 1][j];
                        if(top==wrongValue){
                            top=0;
                        }
                    }
                    if (i + 1 >= 0 && i + 1 <= matrix.length - 1) {
                        bottom = matrix[i + 1][j];
                        if(bottom==wrongValue){
                           bottom=0;
                        }
                    }
                    if (j + 1 >= 0 && j + 1 <= matrix[i].length - 1) {
                        right = matrix[i][j + 1];
                        if(right==wrongValue){
                            right=0;
                        }
                    }
                    if (j - 1 >= 0 && j - 1 <= matrix[i].length - 1) {
                        left = matrix[i][j - 1];
                        if(left==wrongValue){
                            left=0;
                        }
                    }
                    sum = top + bottom + right + left;
                    matrix[i][j] = wrongValue;
                    newMatrix[i][j] =sum;
                } else {
                   newMatrix[i][j] = currentNumber;
                }
            }
        }
        for (int i = 0; i < newMatrix.length ; i++) {
            for (int j = 0; j < newMatrix[i].length ; j++) {
                System.out.print(newMatrix[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
