package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = numbers[0];
        int columns = numbers[1];
        String[][] matrix = new String[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }

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
        int initialRow = row;
        int initialColumn = column;
        boolean pizzaDelivered = false;

        while (!pizzaDelivered) {
            String command = scanner.nextLine();
            int firstRowPosition = row;
            int firstColumnPosition = column;
            //"up", "down", "right", and "left
            switch (command) {
                case "up":
                    row--;
                    if (row < 0) {
                        System.out.println("The delivery is late. Order is canceled.");
                        matrix[initialRow][initialColumn] = " ";
                        printTheMatrix(matrix);
                        return;
                    }
                    break;
                case "down":
                    row++;
                    if (row >= matrix.length) {
                        System.out.println("The delivery is late. Order is canceled.");
                        matrix[initialRow][initialColumn] = " ";
                        printTheMatrix(matrix);
                        return;
                    }
                    break;
                case "right":
                    column++;
                    if (column >= columns) {
                        matrix[initialRow][initialColumn] = " ";
                        System.out.println("The delivery is late. Order is canceled.");
                        printTheMatrix(matrix);
                        return;
                    }
                    break;
                case "left":
                    column--;
                    if (column < 0) {
                        matrix[initialRow][initialColumn] = " ";
                        System.out.println("The delivery is late. Order is canceled.");
                        printTheMatrix(matrix);
                        return;
                    }
                    break;
            }
            String position = matrix[row][column];
            if (position.equals("A")) {
//•	'A' - Represents an address where a pizza needs to be delivered.
                matrix[row][column] = "P";
                System.out.println("Pizza is delivered on time! Next order...");
                pizzaDelivered = true;
            } else if (position.equals("*")) {
//•	'*' - Represents an obstacle or an area where the delivery boy cannot drive.
                row = firstRowPosition;
                column = firstColumnPosition;
            } else if (position.equals("P")) {
//•	'P' - Represents the pizza restaurant.
                matrix[row][column] = "R";
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            } else if (position.equals("-")) {
//•	'-' - Represents the road, the delivery boy can drive over it.
                matrix[row][column] = ".";
            } else if (position.equals(".")) {

            }
        }




            matrix[initialRow][initialColumn] = "B";
        printTheMatrix(matrix);
    }

    public static void printTheMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
