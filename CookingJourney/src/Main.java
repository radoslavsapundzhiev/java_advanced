import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //char ch = '6';
        //int num = 3;
        //int sum = 3 + Character.getNumericValue(ch);
        //System.out.println(sum);
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        fillMatrix(matrix, scanner, n);
        int[] startPosition = getStartPosition(matrix);
        int startRow = startPosition[0];
        int startCol = startPosition[1];
        int totalPrice = 0;
        while (true) {
            String command = scanner.nextLine();
            matrix[startRow][startCol] = '-';
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
            if(positionIsOutOfMatrix(matrix, startRow, startCol)) {
                break;
            }
            if(matrix[startRow][startCol] == 'P') {
                matrix[startRow][startCol] = '-';
                int[] pillarPosition = getPillarPosition(matrix);
                startRow = pillarPosition[0];
                startCol = pillarPosition[1];
            } else if(matrix[startRow][startCol] != '-' &&
                    matrix[startRow][startCol] != 'S') {
                totalPrice += Character.getNumericValue(matrix[startRow][startCol]);
                if(totalPrice >= 50) {
                    matrix[startRow][startCol] = 'S';
                    break;
                }
            }
        }
        if(totalPrice >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.printf("Money: %d%n", totalPrice);
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

    private static boolean positionIsOutOfMatrix(char[][] matrix, int startRow, int startCol) {
        if(startRow < 0 || startRow >= matrix.length ||
            startCol < 0 || startCol >= matrix.length) {
            return true;
        }
        return false;
    }

    private static int[] getPillarPosition(char[][] matrix) {
        int[] pillarPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'P') {
                    pillarPosition[0] = row;
                    pillarPosition[1] = col;
                    break;
                }
            }
        }
        return pillarPosition;
    }

    private static int[] getStartPosition(char[][] matrix) {
        int[] startPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'S') {
                    startPosition[0] = row;
                    startPosition[1] = col;
                    break;
                }
            }
        }
        return startPosition;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner, int n) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
