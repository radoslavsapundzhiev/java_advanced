import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        fillMatrix(matrix, scanner);
        int[] startPosition = getStartPosition(matrix);
        int startRow = startPosition[0];
        int startCol = startPosition[1];
        String direction = scanner.nextLine();
        int flowers = 0;
        while (!direction.equals("End")) {
            matrix[startRow][startCol] = '.';
            switch (direction) {
                case "up":
                    startRow--;
                    break;
                case "down":
                    startRow++;
                    break;
                case "left":
                    startCol--;
                    break;
                case "right":
                    startCol++;
                    break;
            }
            if(startRow < 0 || startRow >= matrix.length || startCol < 0 || startCol >= matrix.length) {
                System.out.println("The bee got lost!");
                break;
            }

            if(matrix[startRow][startCol] == 'O') {
                continue;
            } else if (matrix[startRow][startCol] == 'f') {
                flowers++;
            }
            matrix[startRow][startCol] = 'B';
            direction = scanner.nextLine();
        }
        if(flowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", (5 - flowers));
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] getStartPosition(char[][] matrix) {
        int[] startPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'B') {
                    startPosition[0] = row;
                    startPosition[1] = col;
                }
            }
        }
        return startPosition;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
