import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static int whiteRow = 0;
    private static int whiteCol = 0;
    private static int blackRow = 0;
    private static int blackCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = new String[8][8];
        fillMatrix(matrix, scanner);
        boolean isWhiteTurn = true;
        Map<Integer, String> columns = getColumns();
        Map<Integer, Integer> rows = getRows();
        while (true) {
            if(isWhiteTurn) {
                matrix[whiteRow][whiteCol] = "-";
                whiteRow--;
                if(whiteRow == 0) {
                    String coordinates = columns.get(whiteCol) + rows.get(whiteRow);
                    System.out.printf("Game over! White pawn is promoted to a queen at %s.%n", coordinates);
                    break;
                }
                if(whiteRow >= 0 && whiteCol - 1 >= 0) {
                    if(matrix[whiteRow][whiteCol - 1].equals("b")) {
                        String coordinates = columns.get(whiteCol - 1) + rows.get(whiteRow);
                        System.out.printf("Game over! White capture on %s.%n", coordinates);
                        break;
                    }
                }
                if(whiteRow >= 0 && whiteCol + 1 <= 7) {
                    if(matrix[whiteRow][whiteCol + 1].equals("b")) {
                        String coordinates = columns.get(whiteCol + 1) + rows.get(whiteRow);
                        System.out.printf("Game over! White capture on %s.%n", coordinates);
                        break;
                    }
                }
                matrix[whiteRow][whiteCol] = "w";
                isWhiteTurn = false;
            } else {
                matrix[blackRow][blackCol] = "-";
                blackRow++;
                if(blackRow == 7) {
                    String coordinates = columns.get(blackCol) + rows.get(blackRow);
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n", coordinates);
                    break;
                }
                if(blackRow <= 7 && blackCol - 1 >= 0) {
                    if(matrix[blackRow][blackCol - 1].equals("w")) {
                        String coordinates = columns.get(blackCol - 1) + rows.get(blackRow);
                        System.out.printf("Game over! Black capture on %s.%n", coordinates);
                        break;
                    }
                }
                if(blackRow + 1 <= 7 && blackCol + 1 <= 7) {
                    if(matrix[blackRow][blackCol + 1].equals("w")) {
                        String coordinates = columns.get(blackCol + 1) + rows.get(blackRow);
                        System.out.printf("Game over! Black capture on %s.%n", coordinates);
                        break;
                    }
                }
                matrix[blackRow][blackCol] = "b";
                isWhiteTurn = true;
            }
        }
    }

    private static Map<Integer, Integer> getRows() {
        Map<Integer, Integer> rows = new HashMap<>();
        rows.put(0, 8);
        rows.put(1, 7);
        rows.put(2, 6);
        rows.put(3, 5);
        rows.put(4, 4);
        rows.put(5, 3);
        rows.put(6, 2);
        rows.put(7, 1);
        return rows;
    }

    private static Map<Integer, String> getColumns() {
        Map<Integer, String> columns = new HashMap<>();
        columns.put(0, "a");
        columns.put(1, "b");
        columns.put(2, "c");
        columns.put(3, "d");
        columns.put(4, "e");
        columns.put(5, "f");
        columns.put(6, "g");
        columns.put(7, "h");
        return columns;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < 8; row++) {
            matrix[row] = scanner.nextLine().split("");
            for (int col = 0; col < 8; col++) {
                if(matrix[row][col].equals("w")) {
                    whiteRow = row;
                    whiteCol = col;
                } else if(matrix[row][col].equals("b")) {
                    blackRow = row;
                    blackCol = col;
                }
            }
        }
    }
}
