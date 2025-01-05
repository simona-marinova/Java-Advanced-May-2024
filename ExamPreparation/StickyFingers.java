package ExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = new String[size][size];
        fillTheMatrix(scanner, matrix);
        int row = -1;
        int column = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("D")) {
                    row = i;
                    column = j;
                }
            }
        }
        matrix[row][column] = "+";
        int money = 0;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            boolean isOnTheEdge = false;
            switch (command) {
                case "up":
                    row--;
                    if (row < 0) {
                        isOnTheEdge = true;
                        row++;
                    }
                    break;
                case "down":
                    row++;
                    if (row >= matrix.length) {
                        isOnTheEdge = true;
                        row--;
                    }
                    break;
                case "right":
                    column++;
                    if (column >= matrix[row].length) {
                        isOnTheEdge = true;
                        column--;
                    }
                    break;
                case "left":
                    column--;
                    if (column < 0) {
                        isOnTheEdge = true;
                        column++;
                    }
                    break;
            }
            if (isOnTheEdge) {
                System.out.println("You cannot leave the town, there is police outside!");
            }
            if (matrix[row][column].equals("$")) {
                matrix[row][column] = "+";
                money += row * column;
                System.out.printf("You successfully stole %d$.\n", row * column);
            } else if (matrix[row][column].equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.\n", money);
                matrix[row][column] = "#";
                printTheMatrix(matrix);
                return;
            }
        }
        matrix[row][column] = "D";
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", money);
        printTheMatrix(matrix);
    }

    public static void fillTheMatrix(Scanner scanner, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

    }


    public static void printTheMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            List<String> output = Arrays.stream(matrix[i]).toList();
            System.out.println(output.toString().replace("[", "").replace("]", "").replace(",", ""));
        }
    }
}
