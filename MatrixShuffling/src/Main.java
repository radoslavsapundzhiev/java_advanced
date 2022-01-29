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
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if(!isValidCommandAndSwapElements(command, rows, cols, matrix)){
                System.out.println("Invalid input!");
            } else {
                printMatrix(matrix);
            }
            command = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidCommandAndSwapElements(String command, int rows, int cols, String matrix[][]) {
        String[] commandTokens = command.split("\\s+");
        if(commandTokens.length != 5) {
            return false;
        }
        if(!commandTokens[0].equals("swap")) {
            return false;
        }
        int row1 = Integer.parseInt(commandTokens[1]);
        int col1 = Integer.parseInt(commandTokens[2]);
        int row2 = Integer.parseInt(commandTokens[3]);
        int col2 = Integer.parseInt(commandTokens[4]);
        if(row1 < 0 || row1 >= rows || col1 < 0 || col1 >= cols ||
            row2 < 0 || row2 >= rows || col2 < 0 || col2 >= cols) {
            return false;
        }
        String firstElement = matrix[row1][col1];
        String secondElement = matrix[row2][col2];
        matrix[row1][col1] = secondElement;
        matrix[row2][col2] = firstElement;
        return true;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            matrix[row] = currentRow;
        }
    }
}
