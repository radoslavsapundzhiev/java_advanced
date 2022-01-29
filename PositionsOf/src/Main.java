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
        fillMatrix(matrix, scanner);
        int number = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(number == matrix[row][col]) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
