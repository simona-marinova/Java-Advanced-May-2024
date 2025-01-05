package ExamPreparation;

import java.util.Scanner;

public class FishingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillTheMatrix(matrix, scanner);
        int rowPosition = -1;
        int columnPosition = -1;
        int fishes = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("S")) {
                    rowPosition = i;
                    columnPosition = j;
                }
            }
        }
        String currentPosition = matrix[rowPosition][columnPosition];
        matrix[rowPosition][columnPosition] = "-";

        String command = scanner.nextLine();
        while (!command.equals("collect the nets")) {
            // "up", "down", "left", and "right".
            switch (command) {
                case "up":
                    rowPosition--;
                    if (rowPosition < 0) {
                        rowPosition = matrix.length - 1;
                    }
                    break;
                case "down":
                    rowPosition++;
                    if (rowPosition >= matrix.length) {
                        rowPosition = 0;
                    }
                    break;
                case "left":
                    columnPosition--;
                    if (columnPosition < 0) {
                        columnPosition = matrix.length - 1;
                    }
                    break;
                case "right":
                    columnPosition++;
                    if (columnPosition >= matrix.length) {
                        columnPosition = 0;
                    }
                    break;
            }
//•	If you move to a fish passage, you collect the amount equal to the digit there,
// the passage disappears and should be replaced by '-'.
            currentPosition = matrix[rowPosition][columnPosition];
            char currentChar = currentPosition.charAt(0);
            if (Character.isDigit(currentChar)) {
                int numberOfFishes = Integer.parseInt(currentChar+"");
                fishes += numberOfFishes;
                matrix[rowPosition][columnPosition] = "-";
            } else if (currentPosition.equals("W")) {
                fishes = 0;
                System.out.printf("You fell into a whirlpool! The ship sank" +
                        " and you lost the fish you caught. Last coordinates of the ship: [%d,%d]\n", rowPosition, columnPosition);
                return;
            }
            command = scanner.nextLine();
        }
        matrix[rowPosition][columnPosition] = "S";
        if (fishes >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.\n", 20 - fishes);

        }
        if (fishes > 0) {
            System.out.printf("Amount of fish caught: %d tons.\n", fishes);
        }

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void fillTheMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }
}
