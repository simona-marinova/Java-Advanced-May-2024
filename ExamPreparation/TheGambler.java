package ExamPreparation;

import java.util.Scanner;

public class TheGambler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillTheMatrix(matrix, scanner);
        int money = 100;
        int rowPosition = -1;
        int columnPosition = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("G")) {
                    rowPosition = i;
                    columnPosition = j;
                }
            }
        }

        String command = scanner.nextLine();
        matrix[rowPosition][columnPosition] = "-";

        while (!command.equals("end")) {
//"up", "down", "left" and "right".
            switch (command) {
                case "up":
                    rowPosition--;
                    if (rowPosition < 0) {
                        money = 0;
                        System.out.println("Game over! You lost everything!");
                        return;
                    }
                    break;
                case "down":
                    rowPosition++;
                    if (rowPosition >= matrix.length) {
                        money = 0;
                        System.out.println("Game over! You lost everything!");
                        return;
                    }
                    break;
                case "left":
                    columnPosition--;
                    if (columnPosition < 0) {
                        money = 0;
                        System.out.println("Game over! You lost everything!");
                        return;
                    }
                    break;
                case "right":
                    columnPosition++;
                    if (columnPosition > matrix.length) {
                        money = 0;
                        System.out.println("Game over! You lost everything!");
                        return;
                    }
                    break;
            }
            String letter = matrix[rowPosition][columnPosition];

            switch (letter) {
                case "-":
                    break;
                case "W":
                    money += 100;
                    break;
                case "P":
                    money -= 200;
                    if (money <= 0) {
                        System.out.println("Game over! You lost everything!");
                        return;
                    }
                    break;
                case "J":
                    money += 100000;
                    matrix[rowPosition][columnPosition] ="G";
                    System.out.println("You win the Jackpot!");
                    System.out.printf("End of the game. Total amount: %d$\n", money);
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix.length; j++) {
                            System.out.print(matrix[i][j]);
                        }
                        System.out.println();
                    }
                    return;
            }
            matrix[rowPosition][columnPosition] = "-";
            command = scanner.nextLine();
        }
        matrix[rowPosition][columnPosition] ="G";
        System.out.printf("End of the game. Total amount: %d$\n", money);

        if (money > 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void fillTheMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }
}
