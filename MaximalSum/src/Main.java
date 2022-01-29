import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = matrixSizes[0];
        int cols = matrixSizes[1];
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);
        int[] maxSumOf3x3ElementsAndStartRowCol = getMaxSumOf3x3Elements(matrix);
        int maxSum = maxSumOf3x3ElementsAndStartRowCol[0];
        System.out.println("Sum = " + maxSum);
        int startRow = maxSumOf3x3ElementsAndStartRowCol[1];
        int startCol = maxSumOf3x3ElementsAndStartRowCol[2];
        printPartOfMatrix(matrix, startRow, startCol);
    }

    private static void printPartOfMatrix(int[][] matrix, int startRow, int startCol) {
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[] getMaxSumOf3x3Elements(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        currentSum += matrix[row + i][col + j];
                    }
                }
                if(currentSum > maxSum) {
                    maxSum = currentSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        return new int[]{maxSum, startRow, startCol};
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = currentRow;
        }
    }
}
