package ExamPreparation;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];


        for (int j = 0; j < matrix.length; j++) {
            matrix[j] = scanner.nextLine().split("");

        }
        int rowPosition = -1;
        int columnPosition = -1;


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("P")) {
                    rowPosition = i;
                    columnPosition = j;
                }
            }
        }

        //up", "down", "left", "right".

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            matrix[rowPosition][columnPosition] = "-";
            if (command.equals("up")) {
                rowPosition -= 1;
                if (rowPosition < 0) {
                    rowPosition += 1;
                    matrix[rowPosition][columnPosition] = "P";
                    text.deleteCharAt(text.length() - 1);
                    command = scanner.nextLine();
                    continue;
                }
            } else if (command.equals("down")) {
                rowPosition += 1;
                if (rowPosition > matrix.length - 1) {
                    rowPosition -= 1;
                    matrix[rowPosition][columnPosition] = "P";
                    text.deleteCharAt(text.length() - 1);
                    command = scanner.nextLine();
                    continue;
                }
            } else if (command.equals("left")) {
                columnPosition -= 1;
                if (columnPosition < 0) {
                    columnPosition += 1;
                    matrix[rowPosition][columnPosition] = "P";
                    text.deleteCharAt(text.length() - 1);
                    command = scanner.nextLine();
                    continue;
                }

            } else if (command.equals("right")) {
                columnPosition += 1;
                if (columnPosition > matrix.length - 1) {
                    columnPosition -= 1;
                    matrix[rowPosition][columnPosition] = "P";
                    text.deleteCharAt(text.length() - 1);
                    command = scanner.nextLine();
                    continue;
                }
            }

            if (!matrix[rowPosition][columnPosition].equals("-")) {
                text.append(matrix[rowPosition][columnPosition]);
                matrix[rowPosition][columnPosition] = "P";
            } else {
                matrix[rowPosition][columnPosition] = "P";
            }
            command = scanner.nextLine();
        }

        System.out.println(text);
        printMatrix(matrix);

    }

    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
