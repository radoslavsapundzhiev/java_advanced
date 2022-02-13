import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        fillMatrix(matrix, scanner);
        int[] startPositionAndNiceKids = getStartPositionAndNiceKids(matrix);
        int startRow = startPositionAndNiceKids[0];
        int startCol = startPositionAndNiceKids[1];
        int niceKids = startPositionAndNiceKids[2];
        int initialNiceKidsCount = niceKids;
        int givenPresents = 0;
        String command = scanner.nextLine();
        matrix[startRow][startCol] = "-";
        while (!command.equals("Christmas morning")) {
            matrix[startRow][startCol] = "-";
            switch (command) {
                case "up":
                    if(startRow != 0) {
                        startRow--;
                    }
                    break;
                case "down":
                    if (startRow != matrix.length - 1) {
                        startRow++;
                    }
                    break;
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
            }
            if(matrix[startRow][startCol].equals("V")) {
                givenPresents++;
                niceKids--;
                matrix[startRow][startCol] = "-";
                if(givenPresents >= m) {
                    break;
                }
            } else if (matrix[startRow][startCol].equals("C")) {
                if(matrix[startRow][startCol-1].equals("V") || matrix[startRow][startCol-1].equals("X")) {
                    givenPresents++;
                    if(matrix[startRow][startCol-1].equals("V")) {
                        niceKids--;
                    }
                }
                if(matrix[startRow][startCol+1].equals("V") || matrix[startRow][startCol+1].equals("X")) {
                    givenPresents++;
                    if(matrix[startRow][startCol+1].equals("V")) {
                        niceKids--;
                    }
                }
                if(matrix[startRow-1][startCol].equals("V") || matrix[startRow-1][startCol].equals("X")) {
                    givenPresents++;
                    if(matrix[startRow-1][startCol].equals("V")) {
                        niceKids--;
                    }
                }
                if(matrix[startRow+1][startCol].equals("V") || matrix[startRow+1][startCol].equals("X")) {
                    givenPresents++;
                    if(matrix[startRow+1][startCol].equals("V")) {
                        niceKids--;
                    }
                }
                matrix[startRow][startCol-1] = "-";
                matrix[startRow][startCol+1] = "-";
                matrix[startRow-1][startCol] = "-";
                matrix[startRow+1][startCol] = "-";
                if(givenPresents >= m) {
                    break;
                }
            }
            command = scanner.nextLine();
        }
        matrix[startRow][startCol] = "S";
        if(givenPresents == m ) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);
        if(niceKids < 1) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", initialNiceKidsCount);
        } else {
            System.out.printf("No presents for %d nice kid/s.%n", niceKids);
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(String.join(" ", matrix[row]).trim());
        }
    }

    private static int[] getStartPositionAndNiceKids(String[][] matrix) {
        int[] startPositionAndNiceKids = new int[3];
        int niceKids = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col].equals("S")) {
                    startPositionAndNiceKids[0] = row;
                    startPositionAndNiceKids[1] = col;
                } else if(matrix[row][col].equals("V")) {
                    niceKids++;
                }
            }
        }
        startPositionAndNiceKids[2] = niceKids;
        return startPositionAndNiceKids;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
