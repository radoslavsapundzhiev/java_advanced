import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];
        fillMatrix(firstMatrix, scanner);
        fillMatrix(secondMatrix, scanner);
        char[][] intersection = getIntersection(firstMatrix, secondMatrix, rows, cols);
        printMatrix(intersection);
    }

    private static void printMatrix(char[][] intersection) {
        for (int row = 0; row < intersection.length; row++) {
            for (int col = 0; col < intersection[row].length; col++) {
                System.out.print(intersection[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] getIntersection(char[][] firstMatrix, char[][] secondMatrix, int rows, int cols) {
        char[][] intersection = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(firstMatrix[row][col] == secondMatrix[row][col]) {
                    intersection[row][col] = firstMatrix[row][col];
                } else {
                    intersection[row][col] = '*';
                }
            }
        }
        return intersection;
    }

    private static void fillMatrix(char[][] firstMatrix, Scanner scanner) {
        for (int row = 0; row < firstMatrix.length; row++) {
            String[] currentRowStrings = scanner.nextLine().split("\\s+");
            firstMatrix[row] = new char[firstMatrix[row].length];
            for (int i = 0; i < currentRowStrings.length; i++) {
                firstMatrix[row][i] = currentRowStrings[i].charAt(0);
            }
        }
    }
}
