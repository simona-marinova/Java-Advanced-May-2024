package ExamPreparation;

import java.util.Scanner;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hazelnuts = 0;
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        String[][] matrix = new String[size][size];
        fillTheMatrix(scanner, matrix);
        int row = -1;
        int column = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("s")) {
                    row = i;
                    column = j;
                }
            }
        }

        matrix[row][column] = "*";
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch (command) {
                case "up":
                    row--;
                    if (row < 0) {
                        System.out.println("The squirrel is out of the field.");
                        System.out.printf("Hazelnuts collected: %d", hazelnuts);
                        return;
                    }
                    break;
                case "down":
                    row++;
                    if (row >= matrix.length) {
                        System.out.println("The squirrel is out of the field.");
                        System.out.printf("Hazelnuts collected: %d", hazelnuts);
                        return;
                    }

                    break;
                case "left":
                    column--;
                    if (column < 0) {
                        System.out.println("The squirrel is out of the field.");
                        System.out.printf("Hazelnuts collected: %d", hazelnuts);
                        return;
                    }
                    break;
                case "right":
                    column++;
                    if (column >= matrix.length) {
                        System.out.println("The squirrel is out of the field.");
                        System.out.printf("Hazelnuts collected: %d", hazelnuts);
                        return;
                    }
                    break;
            }

            if (matrix[row][column].equals("h")) {
                hazelnuts++;
                if (hazelnuts == 3) {
                    matrix[row][column] = "s";
                    break;
                } else {
                    matrix[row][column] = "*";
                }
            } else if (matrix[row][column].equals("t")) {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                System.out.printf("Hazelnuts collected: %d", hazelnuts);
                return;
            }
        }
        if (hazelnuts == 3) {
            System.out.println("Good job! You have collected all hazelnuts!");
        } else {
            System.out.println("There are more hazelnuts to collect.");
        }

        System.out.printf("Hazelnuts collected: %d", hazelnuts);
    }

    public static void fillTheMatrix(Scanner scanner, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }

}
