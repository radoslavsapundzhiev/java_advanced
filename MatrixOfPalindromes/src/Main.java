import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String[][] matrix = new String[rows][cols];
        fillTheMatrix(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillTheMatrix(String[][] matrix) {
        char startChar = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String current = "" + startChar + (char)(startChar + col) + startChar;
                matrix[row][col] = current;
            }
            startChar = (char)(startChar + 1);
        }
    }
}
