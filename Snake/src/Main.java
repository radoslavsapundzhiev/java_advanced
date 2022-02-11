import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);
        int[] startPosition = getStartPosition(matrix);
        int startRow = startPosition[0];
        int startCol = startPosition[1];
        int foodQuantity = 0;
        while (true) {
            String command = scanner.nextLine();
            matrix[startRow][startCol] = ".";
            switch (command) {
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
                System.out.println("Game over!");
                break;
            }
            if(matrix[startRow][startCol].equals("B")) {
                matrix[startRow][startCol] = ".";
                int[] positionOfOtherBurrow = getPositionOfOtherBurrow(matrix);
                startRow = positionOfOtherBurrow[0];
                startCol = positionOfOtherBurrow[1];
            } else if (matrix[startRow][startCol].equals("*")) {
                foodQuantity++;
                if(foodQuantity >= 10) {
                    System.out.println("You won! You fed the snake.");
                    matrix[startRow][startCol] = "S";
                    break;
                }
            }
        }
        System.out.printf("Food eaten: %d%n", foodQuantity);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(String.join("", matrix[row]));
        }
    }

    private static int[] getPositionOfOtherBurrow(String[][] matrix) {
        int[] positionOfOtherBurrow = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col].equals("B")) {
                    positionOfOtherBurrow[0] = row;
                    positionOfOtherBurrow[1] = col;
                }
            }
        }
        return positionOfOtherBurrow;
    }

    private static int[] getStartPosition(String[][] matrix) {
        int[] startPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col].equals("S")) {
                    startPosition[0] = row;
                    startPosition[1] = col;
                }
            }
        }
        return startPosition;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
