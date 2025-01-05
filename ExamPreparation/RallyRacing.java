package ExamPreparation;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();
        String[][] matrix = new String[size][size];
        fillTheMatrix(scanner,matrix);
        int row = 0;
        int column = 0;
        int km = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    column--;
                    break;
                case "right":
                    column++;
                    break;
            }
            String position = matrix[row][column];
            if (position.equals(".")) {
                km += 10;
            } else if (position.equals("T")) {
                km += 30;
                matrix[row][column] = ".";
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[i][j].equals("T")) {
                            row = i;
                            column = j;
                        }
                    }
                    matrix[row][column] = ".";
                }
            } else if (position.equals("F")) {
                km += 10;
                System.out.printf("Racing car %s finished the stage!\n", racingNumber);
                System.out.printf("Distance covered %d km.\n", km);
                matrix[row][column] ="C";
                printTheMatrix(matrix);
                return;
            }
            command = scanner.nextLine();

        }
        System.out.printf("Racing car %s DNF.\n",racingNumber);
        System.out.printf("Distance covered %d km.\n", km);
        matrix[row][column] ="C";
        printTheMatrix(matrix);
    }

    public static void fillTheMatrix(Scanner scanner, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
    }
    public static void printTheMatrix (String [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
