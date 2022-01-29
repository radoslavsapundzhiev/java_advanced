import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner, rows, cols);
        int[] data = getMaxSumStartRowStartColOf2x2SubMatrix(matrix);
        int maxSum = data[0];
        int startRow = data[1];
        int startCol = data[2];
        printSubMatrix(matrix, startRow, startCol);
        System.out.println(maxSum);
    }

    private static void printSubMatrix(int[][] matrix, int startRow, int startCol) {
        for (int row = startRow; row < startRow + 2; row++) {
            for (int col = startCol; col < startCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[] getMaxSumStartRowStartColOf2x2SubMatrix(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = 0;
                for (int i = row; i < row + 2; i++) {
                    for (int j = col; j < col + 2; j++) {
                        currentSum += matrix[i][j];
                    }
                }
                if(currentSum > maxSum) {
                    maxSum = currentSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        return new int[] {maxSum, startRow, startCol};
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
