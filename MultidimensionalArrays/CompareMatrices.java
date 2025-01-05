package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);
        boolean areEqual = firstMatrix.length == secondMatrix.length;
        if (areEqual) {
            for (int i = 0; i < firstMatrix.length; i++) {
                int[] firstCurrentArray = firstMatrix[i];
                int[] secondCurrentArray = secondMatrix[i];
                areEqual = firstCurrentArray.length == secondCurrentArray.length;
                if(!areEqual){
                    break;
                }
                if (areEqual) {
                    for (int j = 0; j < firstCurrentArray.length; j++) {
                        int firstNumber = firstCurrentArray[j];
                        int secondNumber = secondCurrentArray[j];
                        if (areEqual) {
                            areEqual = firstNumber == secondNumber;
                        }
                    }
                }
            }
            String output = areEqual ? "equal" : "not equal";
            System.out.println(output);
        }

        }
        public static int[][] readMatrix (Scanner scanner){
            int[] input = readArray(scanner);
            int rows = input[0];
            int columns = input[1];
            int[][] matrix = new int[rows][columns];
            for (int i = 0; i < matrix.length; i++) {
                int[] numbers = readArray(scanner);
                matrix[i] = numbers;
            }
            return matrix;
        }

        public static int[] readArray (Scanner scanner){
            return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }




