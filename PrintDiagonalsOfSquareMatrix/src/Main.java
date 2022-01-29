import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        fillMatrix(matrix, scanner);
        printPrimaryDiagonal(matrix);
        printSecondaryDiagonal(matrix);
    }

    private static void printSecondaryDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[matrix.length - 1 - i][i] + " ");
        }
        System.out.println();
    }

    private static void printPrimaryDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }
    }
}
