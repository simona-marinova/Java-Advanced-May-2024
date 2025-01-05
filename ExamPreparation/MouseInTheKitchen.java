package ExamPreparation;
import java.util.Scanner;
import java.util.Arrays;



public class MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int rows = numbers[0];
        int columns = numbers[1];
    String [][] matrix = new String [rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }

        int rowPosition = -1;
        int columnPosition = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("M")) {
                    rowPosition = i;
                    columnPosition = j;
                    break;
                }
            }
        }

        matrix[rowPosition][columnPosition] = "*";

        String command = scanner.nextLine();
        boolean isTheLastCheese = true;
        boolean theProgramEnds = false;

        while (!command.equals("danger") && !theProgramEnds) {
           int initialRowPosition = rowPosition;
           int initialColumnPosition = columnPosition;
            switch (command) {
                case "up":
                    rowPosition--;
                    if (rowPosition < 0) {
                        rowPosition++;
                        matrix[rowPosition][columnPosition] = "M";
                        theProgramEnds=true;
                        System.out.println("No more cheese for tonight!");
                    }
                    break;
                case "down":
                    rowPosition++;
                    if (rowPosition >= rows) {
                        rowPosition--;
                        matrix[rowPosition][columnPosition] = "M";
                        theProgramEnds=true;
                        System.out.println("No more cheese for tonight!");
                    }
                    break;
                case "left":
                    columnPosition--;
                    if (columnPosition < 0) {
                        columnPosition++;
                        matrix[rowPosition][columnPosition] = "M";
                        theProgramEnds=true;
                        System.out.println("No more cheese for tonight!");
                    }
                    break;
                case "right":
                    columnPosition++;
                    if (columnPosition >= columns) {
                        columnPosition--;
                        matrix[rowPosition][columnPosition] = "M";
                        theProgramEnds=true;
                        System.out.println("No more cheese for tonight!");
                    }
                    break;
            }

            if (matrix[rowPosition][columnPosition].equals("C")) {
                matrix[rowPosition][columnPosition] = "*";
                isTheLastCheese = isTheLastCheese(matrix);
                if (isTheLastCheese) {
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    matrix[rowPosition][columnPosition]="M";
                    printTheMatrix(matrix);
                    return;
                }


            } else if (matrix[rowPosition][columnPosition].equals("@")) {
                rowPosition=initialRowPosition;
            columnPosition=initialColumnPosition;
                command = scanner.nextLine();
                continue;
            } else if (matrix[rowPosition][columnPosition].equals("T")) {
                matrix[rowPosition][columnPosition] = "M";
                System.out.println("Mouse is trapped!");
                printTheMatrix(matrix);
                return;
            }

            command = scanner.nextLine();
        }

        isTheLastCheese=isTheLastCheese(matrix);

        if(!isTheLastCheese && !theProgramEnds){
            matrix[rowPosition][columnPosition]="M";
            System.out.println("Mouse will come back later!");
        }

        printTheMatrix(matrix);
    }

    public static boolean isTheLastCheese(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("C")) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void printTheMatrix (String [][] matrix){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}






