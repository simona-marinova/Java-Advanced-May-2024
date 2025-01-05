package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = readArray(scanner);
        int rows = size[0];
        int columns = size[1];
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            int[] numbers = readArray(scanner);
            matrix[i] = numbers;
        }
        int maxSum = Integer.MIN_VALUE;

        int rowMaxFirstElement =0;
        int columnMaxFirstElement =0;

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int sum=0;
              int firstElement = matrix[i][j];
              int secondElement = matrix[i][j+1];
              int thirdElement = matrix[i][j+2];
              int fourthElement = matrix[i+1][j];
              int fifthElement = matrix [i+1][j+1];
              int sixthElement = matrix [i+1][j+2];
              int seventhElement = matrix [i+2][j];
              int eighthElement = matrix[i+2][j+1];
              int ninthElement = matrix[i+2][j+2];
              sum +=firstElement+secondElement+thirdElement+fourthElement+fifthElement+sixthElement+seventhElement+
                      eighthElement+ninthElement;
              if(sum>maxSum){
                  maxSum=sum;
                  rowMaxFirstElement =i;
                  columnMaxFirstElement=j;
              }
            }
        }

        System.out.printf("Sum = %d\n", maxSum);
        for (int i = rowMaxFirstElement; i <=rowMaxFirstElement+2 ; i++) {
            for (int j = columnMaxFirstElement; j <=columnMaxFirstElement+2 ; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

    }
    public static int[] readArray(Scanner scanner) {
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return numbers;
    }
}
