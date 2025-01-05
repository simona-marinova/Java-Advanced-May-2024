package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(", ");
        int number = Integer.parseInt(array[0]);
        String pattern = array[1];
        int[][] matrix;

        if (pattern.equals("A")) {
            matrix = fillMatrixA(number);
        } else {
            matrix = fillMatrixB(number);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] fillMatrixA(int number) {
        int[][] matrix = new int[number][number];
        int num = 1;
        for (int column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][column] = num;
                num++;
            }

        }
        return matrix;
    }

    public static int[][] fillMatrixB(int number) {
        int[][] matrix = new int[number][number];
        int num = 1;
        for (int column = 0; column < matrix.length; column++) {
            if (column % 2 == 0)
                for (int row= 0; row<matrix.length ; row++) {
                    matrix[row][column] = num++;
                }
                else {
                    for (int row = matrix.length-1; row >=0 ; row--) {
                        matrix[row][column] = num++;
                    }
                }

            }
        return matrix;
        }

    }
