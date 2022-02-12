import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);
        int[] startPosition = getStartPosition(matrix);
        int startRow = startPosition[0];
        int startCol = startPosition[1];
        boolean hasWon = false;
        for (int i = 0; i < countOfCommands; i++) {
            String command = scanner.nextLine();
            if(!matrix[startRow][startCol].equals("B") &&
                    !matrix[startRow][startCol].equals("T")) {
                matrix[startRow][startCol] = "-";
            }
            int oldRow = startRow;
            int oldCol = startCol;
            int[] newPosition = move(command, startRow, startCol, matrix);
            startRow = newPosition[0];
            startCol = newPosition[1];
            
            if(matrix[startRow][startCol].equals("B")) {
                int[] newPositionAfterBonus = move(command, startRow, startCol, matrix);
                startRow = newPositionAfterBonus[0];
                startCol = newPositionAfterBonus[1];
            } else if(matrix[startRow][startCol].equals("T")) {
                startRow = oldRow;
                startCol = oldCol;
            }

            if(matrix[startRow][startCol].equals("F")) {
                hasWon = true;
                break;
            }
        }
        matrix[startRow][startCol] = "f";
        if(hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static int[] move(String command, int startRow, int startCol, String[][] matrix) {
        int[] newPosition = new int[2];
        switch (command) {
            case "up":
                startRow--;
                if(startRow < 0) {
                    startRow = matrix.length - 1;
                }
                break;
            case "down":
                startRow++;
                if(startRow >= matrix.length) {
                    startRow = 0;
                }
                break;
            case "left":
                startCol--;
                if(startCol < 0) {
                    startCol = matrix.length - 1;
                }
                break;
            case "right":
                startCol++;
                if(startCol >= matrix.length) {
                    startCol = 0;
                }
                break;
        }
        newPosition[0] = startRow;
        newPosition[1] = startCol;
        return newPosition;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(String.join("", matrix[row]));
        }
    }

    private static int[] getStartPosition(String[][] matrix) {
        int[] startPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col].equals("f")) {
                    startPosition[0] = row;
                    startPosition[1] = col;
                    break;
                }
            }
        }
        return startPosition;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
