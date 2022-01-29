import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputTokens = scanner.nextLine().split(", ");
        int size = Integer.parseInt(inputTokens[0]);
        String pattern = inputTokens[1];
        int[][] matrix = new int[size][size];
        if(pattern.equals("A")) {
            fillMatrixPatternA(matrix);
        } else {
            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix);
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            if(col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0 ; row--) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
    }
}
