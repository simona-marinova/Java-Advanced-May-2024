package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = size[0];
        int column = size[1];
        String[][] matrix = new String[row][column];

        for (int i = 0; i < matrix.length; i++) {
String [] input = scanner.nextLine().split(" ");
            matrix[i] = input;
        }
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commands = command.split(" ");
            if (commands[0].equals("swap") && commands.length == 5) {
                   //swap row1 col1 row2c col2
                int row1 = Integer.parseInt(commands[1]);
                int col1 = Integer.parseInt(commands[2]);
                if(row1<0 || row1 >matrix.length-1 || col1<0 || col1>column-1){
                    System.out.println("Invalid input!");
                    command = scanner.nextLine();
                    continue;
                }
                int row2 = Integer.parseInt(commands[3]);
                int col2 = Integer.parseInt(commands[4]);
                if(row2<0 || row2 >matrix.length-1 || col2<0 || col2>column-1){
                    System.out.println("Invalid input!");
                    command = scanner.nextLine();
                    continue;
                }
                String firstValue = matrix[row1][col1];
                String secondValue = matrix[row2][col2];
                matrix[row1][col1] = secondValue;
                matrix[row2][col2] = firstValue;
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        System.out.print(matrix[i][j]+ " ");
                    }
                    System.out.println();
                }

            } else {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            command = scanner.nextLine();
        }


    }


}

