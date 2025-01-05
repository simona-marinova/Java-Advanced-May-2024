package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = new char[row][col];
        char[][] secondMatrix = new char[row][col];
        firstMatrix = readMatrix(firstMatrix, scanner);
        secondMatrix = readMatrix(secondMatrix, scanner);
        char[][] newMatrix = new char[row][col];
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                char firsChar = firstMatrix[i][j];
                char secondChar = secondMatrix[i][j];
                if (firsChar == secondChar) {
                    newMatrix[i][j] = firsChar;
                } else {
                    newMatrix[i][j] = '*';
                }
            }

        }

        for (int i = 0; i < newMatrix.length ; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                char currentChar = newMatrix[i][j];
                System.out.print(currentChar+ " ");
            }
            System.out.println();

        }
    }

    private static char[][] readMatrix(char[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            String chars = scanner.nextLine().replace(" ", "");
            char[] charArray = chars.toCharArray();
            matrix[i] = charArray;
        }
        return matrix;
    }
}
