package MultidimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        String[][] matrix = new String[rows][columns];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = generateFirstAndLastLetter(row, column);
            }
        }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int asciiCode = 97 + i + j;
                    char symbol = (char) asciiCode;
                    String middleLetter = symbol + "";
                    String oldString = matrix[i][j];
                   String newString = oldString.replace(" ", middleLetter);
                    matrix[i][j] = newString;
                }
            }


        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static String generateFirstAndLastLetter(int row, int column) {
        String currentString = "";
        switch (row) {
            case 0 -> currentString = "a a";
            case 1 -> currentString = "b b";
            case 2 -> currentString = "c c";
            case 3 -> currentString = "d d";
            case 4 -> currentString = "e e";
            case 5 -> currentString = "f f";
            case 6 -> currentString = "g g";
            case 7 -> currentString = "h h";
            case 8 -> currentString= "i i";
            case 9 -> currentString = "j j";
            case 10 -> currentString = "k k";
            case 11 -> currentString = "l l";
            case 12 -> currentString = "m m";
            case 13 -> currentString = "n n";
            case 14 -> currentString = "o o";
            case 15 -> currentString = "p p";
            case 16 -> currentString = "q q";
            case 17 -> currentString = "r r";
            case 18 -> currentString = "s s";
            case 19 -> currentString = "t t";
            case 20 -> currentString = "u u";
            case 21 -> currentString = "v v";
            case 22 -> currentString = "w w";
            case 23 -> currentString = "x x";
            case 24 -> currentString = "y y";
            case 25 -> currentString = "z z";
        }
        return currentString;
    }
}

