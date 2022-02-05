import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        String[] directions = scanner.nextLine().split(",\\s+");
        fillMatrix(matrix, scanner, size);
        int[] startPosition = getStartPosition(matrix);
        int pythonRow = startPosition[0];
        int pythonCol = startPosition[1];
        int startLength = 1;
        int leftFood = getLeftFood(matrix);
        for (int i = 0; i < directions.length; i++) {
            matrix[pythonRow][pythonCol] = '*';
            switch (directions[i]) {
                case "up":
                    pythonRow--;
                    break;
                case "down":
                    pythonRow++;
                    break;
                case "left":
                    pythonCol--;
                    break;
                case "right":
                    pythonCol++;
                    break;
            }
            pythonRow = checkRowIsInsideMatrix(matrix, pythonRow);
            pythonCol = checkColIsInsideMatrix(matrix, pythonCol);
            if(matrix[pythonRow][pythonCol] == 'f') {
                startLength++;
                matrix[pythonRow][pythonCol] = '*';
            } else if (matrix[pythonRow][pythonCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            leftFood = getLeftFood(matrix);
            if(leftFood == 0) {
                System.out.printf("You win! Final python length is %d%n", startLength);
                return;
            }
        }
        System.out.printf("You lose! There is still %d food to be eaten.%n", leftFood);
    }

    private static int getLeftFood(char[][] matrix) {
        int food = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'f') {
                    food++;
                }
            }
        }
        return food;
    }

    private static int checkColIsInsideMatrix(char[][] matrix, int pythonCol) {
        if(pythonCol < 0) {
            return matrix.length - 1;
        } else if(pythonCol >= matrix.length) {
            return 0;
        }
        return pythonCol;
    }

    private static int checkRowIsInsideMatrix(char[][] matrix, int pythonRow) {
        if(pythonRow < 0) {
            return matrix.length - 1;
        } else if (pythonRow >= matrix.length) {
            return 0;
        }
        return pythonRow;
    }

    private static int[] getStartPosition(char[][] matrix) {
        int[] positions = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 's') {
                    positions[0] = row;
                    positions[1] = col;
                }
            }
        }
        return positions;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner, int size) {
        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner
                    .nextLine()
                    .split("\\s+");
            matrix[row] = new char[currentRow.length];
            for (int col = 0; col < currentRow.length; col++) {
                matrix[row][col] = currentRow[col].charAt(0);
            }
        }
    }
}
