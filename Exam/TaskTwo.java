package Exam;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.function.Function;
import java.util.Map;


public class TaskTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][];
        fillTheMatrix(scanner, matrix);
        int energy = 15;
        int nectar = 0;
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

        int number = 1;
        matrix[row][column] = "-";
        String command = scanner.nextLine();
        while (energy > 0) {
            energy = energy - 1;
            //•	If the bee runs out of energy, and the total amount of collected
            // nectar is less than 30 units, the program ends.
            switch (command) {
                case "up":
                    row--;
                    if (row < 0) {
                        row = matrix.length - 1;
                    }
                    break;
                case "down":
                    row++;
                    if (row > matrix.length - 1) {
                        row = 0;
                    }
                    break;
                case "right":
                    column++;
                    if (column > matrix.length - 1) {
                        column = 0;
                    }
                    break;
                case "left":
                    column--;
                    if (column < 0) {
                        column = matrix.length - 1;
                    }
                    break;
            }
            String position = matrix[row][column];
            char isDigit = position.charAt(0);
            if (Character.isDigit(isDigit)) {
                nectar += Integer.parseInt(isDigit + "");
                matrix[row][column] = "-";
            } else if (position.equals("H")) {
                //the program ends
                //Hint: If reaching the hive with zero energy, the success will depend on the amount of the collected nectar.
                if (nectar >= 30) {
                    System.out.printf("Great job, Beesy! The hive is full. Energy left: %d\n", energy);
                    matrix[row][column]="B";
                    printTheMatrix(matrix);
                    return;
                } else {
                    System.out.println("Beesy did not manage to collect enough nectar.");
                    matrix[row][column]="B";
                    printTheMatrix(matrix);
                    return;
                }
            }
            if (energy <= 0 && nectar < 30) {
                System.out.println("This is the end! Beesy ran out of energy.");
                matrix[row][column]="B";
                printTheMatrix(matrix);
                return;
            } else if (energy <= 0 && nectar >= 30 && number == 1) {
                int energyToRestore = nectar - 30;
                nectar = 30;
                energy += energyToRestore;
                number = 2;
                if (energy <= 0) {

                }
            } else if (energy <= 0 && number == 2) {
                System.out.println("This is the end! Beesy ran out of energy.");
                matrix[row][column]="B";
                printTheMatrix(matrix);
                return;
            }
            matrix[row][column] = "-";
            command = scanner.nextLine();
        }
        matrix[row][column]="B";
        printTheMatrix(matrix);

    }

    public static void fillTheMatrix(Scanner scanner, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }
    public static void printTheMatrix (String[][] matrix){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
