package ExamPreparation;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillTheMatrix(scanner, matrix);
        int row = -1;
        int column = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("S")) {
                    row = i;
                    column = j;
                }
            }
        }

        int hits = 0;
        int battleCruiser = 0;
        matrix[row][column] ="-";
        while (hits < 3 && battleCruiser < 3) {
            String command = scanner.nextLine();
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
            //    if(position.equals("-")){
            //    }
            if (position.equals("*")) {
                hits++;
                matrix[row][column] = "-";
            } else if (position.equals("C")) {
                battleCruiser++;
                matrix[row][column] = "-";
            }
        }

        matrix[row][column] ="S";
        if (hits == 3) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n", row, column);
        } else if (battleCruiser == 3) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }
printTheMatrix(matrix);
    }

    public static void fillTheMatrix(Scanner scanner, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }

    public static void printTheMatrix (String [][]matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
