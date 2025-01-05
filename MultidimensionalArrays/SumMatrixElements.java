package MultidimensionalArrays;
import java.util.Arrays;
import java.util.Scanner;



public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = numbers[0];
        int columns = numbers[1];
        int [][] matrix = new int[rows][columns];
        matrix=readMatrix(matrix, scanner);
        System.out.println(rows);
        System.out.println(columns);
        int sum =0;

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                int currentNumber = matrix[i][j];
                sum+=currentNumber;
            }
        }

        System.out.println(sum);
    }

    public static int [][] readMatrix ( int [][] matrix, Scanner scanner) {

        for (int i = 0; i <matrix.length ; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[i]=numbers;
        }
        return matrix;

        }
    }

