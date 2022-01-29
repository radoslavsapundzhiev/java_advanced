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
        fillMatrix(matrix ,scanner);
        printReverseMatrixDiagonals(matrix, rows, cols);
    }

    private static void printReverseMatrixDiagonals(int[][] matrix, int rows, int cols) {
        System.out.println(matrix[rows - 1][cols - 1]);
        for (int i = 0; i < rows - 1 ; i++) {
            for (int j = cols - 2; j < cols; j++) {
                System.out.print(matrix[j - i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(matrix[0][0]);
//        System.out.println(matrix[rows-1][cols-1]);
//        for (int col = cols - 1; col >= 0 ; col--) {
//            for (int i = col; i < cols; i++) {
//                System.out.print(matrix[rows - 1 - col][col]);
//            }
//            System.out.println();
//        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
