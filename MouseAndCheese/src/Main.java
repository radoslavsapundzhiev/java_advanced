import java.util.Scanner;

public class Main {
    private static int mouseRow;
    private static int mouseCol;
    private static int bonusRow = -1;
    private static int bonusCol = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        fillMatrixAndGetMouseAndBonusCoordinates(matrix, scanner);
        String command = scanner.nextLine();
        int eatenCheese = 0;
        boolean isOut = false;
        while (!command.equals("end")) {
            matrix[mouseRow][mouseCol] = "-";
            switch (command) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }
            if(mouseRow < 0 || mouseRow >= matrix.length || mouseCol < 0 || mouseCol >= matrix.length) {
                isOut = true;

                break;
            }
            if(matrix[mouseRow][mouseCol].equals("B")) {
                continue;
            } else if (matrix[mouseRow][mouseCol].equals("c")) {
                eatenCheese++;
            }
            command = scanner.nextLine();
        }
        if(isOut) {
            System.out.println("Where is the mouse?");
        } else {
            matrix[mouseRow][mouseCol] = "M";
        }
        if(eatenCheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(String.join("", matrix[row]));
        }
    }

    private static void fillMatrixAndGetMouseAndBonusCoordinates(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col].charAt(0) == 'M'){
                    mouseRow = row;
                    mouseCol = col;
                } else if(matrix[row][col].charAt(0) == 'B') {
                    bonusRow = row;
                    bonusCol = col;
                }
            }
        }
    }
}
