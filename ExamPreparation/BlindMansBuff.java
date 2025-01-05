package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = numbers[0];
        int columns = numbers[1];
        String[][] matrix = new String[rows][columns];
        fillTheMatrix(matrix, scanner);
        int row = -1;
        int column = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("B")) {
                    row = i;
                    column = j;
                }
            }
        }

        String command = scanner.nextLine();
        int moves = 0;
        int touchedOpponents = 0;

        while (!command.equals("Finish")) {
            int initialRow = row;
            int initialColumn = column;
            switch (command) {
                case "up":
                    row--;
                    moves++;
                    if (row<0) {
                        moves--;
                        row++;
                    }
                    break;
                case "down":
                    row++;
                    moves++;
                    if (row >= rows) {
                        moves--;
                        row --;
                    }
                    break;
                case "left":
                    moves++;
                    column--;
                    if (column < 0) {
                        moves--;
                        column = 0;
                    }
                    break;
                case "right":
                    column++;
                    moves++;
                    if (column >= columns) {
                        moves--;
                        column--;
                    }
                    break;
            }
            String position = matrix[row][column];
            if (position.equals("O")) {
                moves--;
                row = initialRow;
                column = initialColumn;
            } else if (position.equals("P")) {
                matrix[row][column] = "-";
                touchedOpponents++;
                if (touchedOpponents == 3) {
                    System.out.println("Game over!");
                    System.out.printf("Touched opponents: %d Moves made: %d\n", touchedOpponents, moves);
                    return;
                }

            }
            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d\n", touchedOpponents, moves);
    }

    public static void fillTheMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

    }
}
