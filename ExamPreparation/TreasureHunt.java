package ExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = numbers [0];
        int columns = numbers [1];
        String[][] matrix = new String[rows][];
        fillTheMatrix(scanner, matrix);
        List<String> directions = new ArrayList<>();
        int row = -1;
        int column = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("Y")) {
                    row = i;
                    column = j;
                    break;
                }
            }
        }

        String command = scanner.nextLine();


        while (!command.equals("Finish")) {
            boolean isRightDirection = true;
            int initialRow = row;
            int initialColumn = column;
            switch (command) {
                case "up":
                    row--;
                    if (row < 0) {
                        isRightDirection = false;
                        row++;
                    }
                    break;
                case "down":
                    row++;
                    if (row >= matrix.length) {
                        isRightDirection = false;
                        row--;
                    }
                    break;
                case "right":
                    column++;
                    if (column >= matrix[row].length) {
                        isRightDirection = false;
                        column--;
                    }
                    break;
                case "left":
                    column--;
                    if (column < 0) {
                        isRightDirection = false;
                        column++;
                    }
                    break;
            }
            String position = matrix[row][column];
            if (position.equals("T")) {
                isRightDirection=false;
                row = initialRow;
                column = initialColumn;

            }
            if (isRightDirection) {
                directions.add(command);
            }
            command = scanner.nextLine();
        }

        if (matrix[row][column].equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.printf(String.join(", ", directions));
        }
        else {
            System.out.println("The map is fake!");
        }

    }

    public static void fillTheMatrix(Scanner scanner, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
    }

}









