import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstRows = firstDimensions[0];
        int firstCols = firstDimensions[1];
        int[][] firstMatrix = new int[firstRows][firstCols];
        fillMatrix(firstMatrix, scanner);
        int[] secondDimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int secondRows = secondDimensions[0];
        int secondCols = secondDimensions[1];
        int[][] secondMatrix = new int[secondRows][secondCols];
        fillMatrix(secondMatrix, scanner);
        if(isMatricesEqual(firstMatrix, secondMatrix, firstRows, firstCols, secondRows, secondCols)){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean isMatricesEqual(int[][] firstMatrix, int[][] secondMatrix, int firstRows, int firstCols, int secondRows, int secondCols) {
        if(firstRows != secondRows || firstCols != secondCols) {
            return false;
        }
        for (int row = 0; row < firstRows; row++) {
            for (int col = 0; col < firstCols; col++) {
                if(firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void fillMatrix(int[][] firstMatrix, Scanner scanner) {
        for (int row = 0; row < firstMatrix.length; row++) {
            firstMatrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
