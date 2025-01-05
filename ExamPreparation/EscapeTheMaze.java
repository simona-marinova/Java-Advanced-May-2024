package ExamPreparation;

import java.util.Scanner;

public class EscapeTheMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size =Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillTheMatrix(matrix, scanner);
        int[] health = {100};
        int rowPosition = -1;
        int columnPosition = -1;
        boolean isFound = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("P")) {
                    rowPosition = i;
                    columnPosition = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }

        matrix[rowPosition][columnPosition] = "-";
        String letter = "";

        while (!letter.equals("X") && health[0]>0) {
            String command = scanner.nextLine();
            //"up", "down", "right", and "left",
            switch (command) {
                case "up":
                    rowPosition--;
                    if (rowPosition < 0) {
                        rowPosition++;
                        continue;
                    }
                    letter = matrix[rowPosition][columnPosition];
                    matrix = changeTheMatrix(matrix, letter, rowPosition, columnPosition, health);
                    break;
                case "down":
                    rowPosition++;
                    if (rowPosition > matrix.length - 1) {
                        rowPosition--;
                        continue;
                    }
                    letter = matrix[rowPosition][columnPosition];
                    matrix = changeTheMatrix(matrix, letter, rowPosition, columnPosition, health);
                    break;
                case "right":
                    columnPosition++;
                    if (columnPosition > matrix.length - 1) {
                        columnPosition--;
                        continue;
                    }
                    letter = matrix[rowPosition][columnPosition];
                    matrix = changeTheMatrix(matrix, letter, rowPosition, columnPosition, health);
                    break;
                case "left":
                    columnPosition--;
                    if (columnPosition < 0) {
                        columnPosition++;
                        continue;
                    }
                    letter = matrix[rowPosition][columnPosition];
                    matrix = changeTheMatrix(matrix, letter, rowPosition, columnPosition, health);
                    break;
            }
        }
        matrix[rowPosition][columnPosition] = "P";
        if(health[0]>0){
            System.out.println("Player escaped the maze. Danger passed!");
        }
        System.out.printf("Player's health: %d units\n", health[0]);
        printTheMatrix(matrix);

    }

    public static void fillTheMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }

    public static String[][] changeTheMatrix(String[][] matrix, String letter, int rowPosition, int columnPosition, int[] health) {
        switch (letter) {
            case "X":
                //Once the traveller successfully reaches a position marked as 'X',
                // he finally reaches the exit and escapes the maze. The adventure is over.
                matrix[rowPosition][columnPosition] = "P";
                break;
            case "M":
                health[0] = health[0] - 40;
                if (health[0] <= 0) {
                    health[0] = 0;
                    System.out.println("Player is dead. Maze over!");
                    break;
                } else {
                    matrix[rowPosition][columnPosition] = "-";
                }
                break;
            case "H":
                health[0] = health[0] + 15;
                if (health[0] > 100) {
                    health[0] = 100;
                }
                matrix[rowPosition][columnPosition] = "-";
                break;
            case "-":
                break;
        }
        return matrix;
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