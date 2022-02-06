import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        String[] directions = scanner.nextLine().split(",");
        fillMatrix(matrix, scanner);
        int[] startPosition = getStartPosition(matrix);
        int startRow = startPosition[0];
        int startCol = startPosition[1];
        int countOfBombs = getLeftBombs(matrix);
        for (int i = 0; i < directions.length; i++) {
            String currentDirection = directions[i];
            matrix[startRow][startCol] = '+';
            switch (currentDirection) {
                case "left":
                    if(startCol != 0) {
                        startCol--;
                    }
                    break;
                case "right":
                    if(startCol != matrix.length - 1) {
                        startCol++;
                    }
                    break;
                case "up":
                    if(startRow != 0) {
                        startRow--;
                    }
                    break;
                case "down":
                    if(startRow != matrix.length - 1) {
                        startRow++;
                    }
                    break;
            }
            if(matrix[startRow][startCol] == 'B') {
                countOfBombs--;
                matrix[startRow][startCol] = '+';
                System.out.println("You found a bomb!");
            } else if(matrix[startRow][startCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", countOfBombs);
                return;
            }
            if(countOfBombs == 0) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", countOfBombs, startRow, startCol);
    }

    private static int getLeftBombs(char[][] matrix) {
        int leftBombs = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'B') {
                    leftBombs++;
                }
            }
        }
        return leftBombs;
    }

    private static int[] getStartPosition(char[][] matrix) {
        int[] startPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 's') {
                    startPosition[0] = row;
                    startPosition[1] = col;
                    break;
                }
            }
        }
        return startPosition;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = currentRow[col].charAt(0);
            }
        }
    }
}
