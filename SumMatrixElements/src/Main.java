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
        int sum = getSumOfMatrixElements(matrix, rows, cols);
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static int getSumOfMatrixElements(int[][] matrix, int rows, int cols) {
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
