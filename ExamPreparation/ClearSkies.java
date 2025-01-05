package ExamPreparation;

import java.util.Scanner;

public class ClearSkies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillTheMatrix(matrix, scanner);
        int armour = 300;
        int counter = 0;
        int rowPosition = -1;
        int columnPosition = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("J")) {
                    rowPosition = i;
                    columnPosition = j;
                }
            }
        }
        matrix[rowPosition][columnPosition] = "-";
        String currentPosition = matrix[rowPosition][columnPosition];
        boolean isDamaged = false;

        while (counter <= 4) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    rowPosition--;
                    currentPosition = matrix[rowPosition][columnPosition];
                    break;
                case "down":
                    rowPosition++;
                    currentPosition = matrix[rowPosition][columnPosition];
                    break;
                case "left":
                    columnPosition--;
                    currentPosition = matrix[rowPosition][columnPosition];
                    break;
                case "right":
                    columnPosition++;
                    currentPosition = matrix[rowPosition][columnPosition];
                    break;
            }
            switch (currentPosition) {
                case "-":
                    break;
                case "E":
                    counter++;
                    if (counter < 4) {
                        armour = armour - 100;
                    }
                    if (armour > 0 && counter == 4) {
                        System.out.println("Mission accomplished, you neutralized the aerial threat!");
                        matrix[rowPosition][columnPosition] = "J";
                        printTheMatrix(matrix);
                        return;
                    }
                   else if (armour == 0) {
                        System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!\n", rowPosition, columnPosition);
                        matrix[rowPosition][columnPosition] = "J";
                        printTheMatrix(matrix);
                        return;
                    }
                    matrix[rowPosition][columnPosition] = "-";
                    break;
                case "R":
                    if (counter != 0) {
                        armour = armour + 300;
                    }
                    matrix[rowPosition][columnPosition] = "-";
                    break;
            }
        }

        matrix[rowPosition][columnPosition] = "J";
        boolean allEnemiesShot = true;

        for (
                int i = 0;
                i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("E")) {
                    allEnemiesShot = false;
                }
            }
        }
    }

    public static void fillTheMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }


    public static void printTheMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
