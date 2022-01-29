import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String rotateCommand = scanner.nextLine();
        int degrees = 0;
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(rotateCommand);
        if(matcher.find()) {
            degrees = Integer.parseInt(matcher.group());
        }
        String inputLine = scanner.nextLine();
        int cols = 0;
        while (!inputLine.equals("END")) {
            if(inputLine.length() > cols) {
                cols = inputLine.length();
            }
            queue.offer(inputLine);
            inputLine = scanner.nextLine();
        }
        int rows = queue.size();
        char[][] matrix = new char[rows][cols];
        fillMatrix(matrix, queue);
        degrees = degrees % 360;
        if(degrees == 90) {
            char[][] rotated90 = rotateMatrix90(matrix);
            printMatrix(rotated90);
        } else if(degrees == 180){
           char[][] rotated180 = rotateMatrix180(matrix);
            printMatrix(rotated180);
        } else if(degrees == 270){
            char[][] rotated270 = rotateMatrix270(matrix);
            printMatrix(rotated270);
        } else if(degrees == 0){
            printMatrix(matrix);
        }
    }

    private static char[][] rotateMatrix270(char[][] matrix) {
        int rows = matrix.length;
        int cols = 0;
        if(rows > 0){
            cols = matrix[0].length;
        }
        char[][] rotated = new char[cols][rows];
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                rotated[cols - 1 - col][row] = matrix[row][col];
            }
        }
        return rotated;
    }

    private static char[][] rotateMatrix180(char[][] matrix) {
        int rows = matrix.length;
        int cols = 0;
        if(rows > 0){
            cols = matrix[0].length;
        }
        char[][] rotated = new char[rows][cols];
        for (int row = rows - 1; row >= 0 ; row--) {
            for (int col = cols - 1; col >= 0 ; col--) {
                rotated[rows - 1 - row][cols - 1 - col] = matrix[row][col];
            }
        }
        return rotated;
    }

    private static void printMatrix(char[][] rotated) {
        for (int row = 0; row < rotated.length; row++) {
            for (int col = 0; col < rotated[row].length; col++) {
                System.out.print(rotated[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] rotateMatrix90(char[][] matrix) {
        int rows = matrix.length;
        int cols = 0;
        if(rows > 0){
            cols = matrix[0].length;
        }
        char[][] rotated = new char[cols][rows];
        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {
                rotated[col][rows - 1 - row] = matrix[row][col];
            }
        }
        return rotated;
    }

    private static void fillMatrix(char[][] matrix, ArrayDeque<String> queue) {
        while (!queue.isEmpty()) {
            for (int row = 0; row < matrix.length; row++) {
                String currentRow = queue.poll();
                for (int col = 0; col < matrix[row].length; col++) {
                    if(col < currentRow.length()) {
                        matrix[row][col] = currentRow.charAt(col);
                    } else {
                        matrix[row][col] = ' ';
                    }
                }
            }
        }
    }
}
