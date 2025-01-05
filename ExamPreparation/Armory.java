package ExamPreparation;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.function.Function;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillTheMatrix(scanner, matrix);
        int row = -1;
        int column = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("A")) {
                    row = i;
                    column = j;
                }
            }
        }
        matrix[row][column] = "-";
        int money = 0;
        boolean programEnds = false;
        while (!programEnds) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    row--;
                    if (row < 0) {
                        System.out.println("I do not need more swords!");
                        programEnds = true;
                    }
                    break;
                case "down":
                    row++;
                    if (row >= matrix.length) {
                        System.out.println("I do not need more swords!");
                        programEnds = true;
                    }
                    break;
                case "right":
                    column++;
                    if (column >= matrix[row].length) {
                        System.out.println("I do not need more swords!");
                        programEnds = true;
                    }
                    break;
                case "left":
                    column--;
                    if (column < 0) {
                        System.out.println("I do not need more swords!");
                        programEnds = true;
                    }
                    break;
            }
            if (!programEnds) {
                String position = matrix[row][column];
                char firstChar = position.charAt(0);
                if (Character.isDigit(firstChar)) {
                    //sword
                    money += Integer.parseInt(firstChar + "");
                    matrix[row][column] = "-";
                    if (money >= 65) {
                        matrix[row][column]="A";
                        programEnds = true;
                    }
                } else if (position.equals("M")) {
                    matrix[row][column] = "-";
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            if (matrix[i][j].equals("M")) {
                                row = i;
                                column = j;
                            }
                        }
                    }
                    matrix[row][column] = "-";
                }

            }
        }

        if (money >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.\n", money);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void fillTheMatrix(Scanner scanner, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }
}
