import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix);
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int[] commandTokens = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = commandTokens[0];
            int col = commandTokens[1];
            int radius = commandTokens [2];
            if(hasValidCoordinates(matrix, row, col) && radius >= 0) {
                destroyMatrixCells(matrix, row, col, radius);
            }
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean hasValidCoordinates(int[][] matrix, int row, int col) {
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) {
            return false;
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void destroyMatrixCells(int[][] matrix, int rowTarget, int colTarget, int radius) {
        for (int row = 0; row < matrix.length; row++) {
            if(row == rowTarget) {
                for (int j = Math.max(0, colTarget - radius); j < Math.min(matrix[row].length, colTarget + radius); j++) {
                    matrix[rowTarget][j] = 0;
                }

            }
        }
        for (int i = Math.max(0, rowTarget - radius); i < Math.min(matrix.length, rowTarget + radius); i++) {
            if(matrix[i].length > colTarget) {
                matrix[i][colTarget] = 0;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(matrix[row])
                    .filter(e -> e != 0)
                    .toArray();
            matrix[row] = currentRow;
        }
    }

    private static void fillMatrix(int[][] matrix) {
        int startNumber = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
    }
}
