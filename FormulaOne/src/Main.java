import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int commandCount = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        int[] playerPosition = getPlayerPosition(matrix);
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];
        String command = scanner.nextLine();
        while (commandCount > 0) {
            int lastRow = playerRow;
            int lastCol = playerCol;
            if(matrix[playerRow][playerCol] != 'B' &&
                matrix[playerRow][playerCol] != 'T'){
                matrix[playerRow][playerCol] = '.';
            }

            switch (command) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }

            if(playerRow < 0) {
                playerRow = size - 1;
            } else if (playerRow >= size) {
                playerRow = 0;
            }

            if(playerCol < 0) {
                playerCol = size - 1;
            } else if(playerCol >= size) {
                playerCol = 0;
            }

            if(matrix[playerRow][playerCol] == 'B') {
                continue;
            } else if(matrix[playerRow][playerCol] == 'T') {
                playerRow = lastRow;
                playerCol = lastCol;
            } else if(matrix[playerRow][playerCol] == 'F') {
                break;
            }
            commandCount--;
            if(commandCount > 0) {
                command = scanner.nextLine();
            }
        }
        if(matrix[playerRow][playerCol] == 'F') {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        matrix[playerRow][playerCol] = 'P';
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

    private static int[] getPlayerPosition(char[][] matrix) {
        int[] position = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'P') {
                    position[0] = row;
                    position[1] = col;
                }
            }
        }
        return position;
    }
}
