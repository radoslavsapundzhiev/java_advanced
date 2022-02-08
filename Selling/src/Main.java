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
        int collectedMoney = 0;
        while (true) {
            String direction = scanner.nextLine();
            matrix[startRow][startCol] = '-';
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
                System.out.println("Bad news, you are out of the bakery.");
                System.out.printf("Money: %d%n", collectedMoney);
                printMatrix(matrix);
                return;
            }

            if(matrix[startRow][startCol] == 'O') {
                matrix[startRow][startCol] = '-';
                int[] otherPillarPosition = getOtherPillarPosition(matrix);
                startRow = otherPillarPosition[0];
                startCol = otherPillarPosition[1];
            } else if(matrix[startRow][startCol] != '-') {
                collectedMoney += Integer.parseInt(String.valueOf(matrix[startRow][startCol]));
                if(collectedMoney >= 50) {
                    System.out.println("Good news! You succeeded in collecting enough money!");
                    System.out.printf("Money: %d%n", collectedMoney);
                    matrix[startRow][startCol] = 'S';
                    printMatrix(matrix);
                    return;
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] getOtherPillarPosition(char[][] matrix) {
        int[] pillarPossition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'O') {
                    pillarPossition[0] = row;
                    pillarPossition[1] = col;
                }
            }
        }
        return pillarPossition;
    }

    private static int[] getStartPosition(char[][] matrix) {
        int[] startPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'S') {
                    startPosition[0] = row;
                    startPosition[1] = col;
                }
            }
        }
        return startPosition;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner
                    .nextLine()
                    .toCharArray();
        }
    }
}
