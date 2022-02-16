import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int e = Integer.parseInt(scanner.nextLine());
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[numberOfRows][];
        int parisRow = 0;
        int parisCol = 0;
        for (int row = 0; row < numberOfRows; row++) {
            matrix[row] = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col].equals("P")) {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }
        int usedEnergy = 0;
        while (true) {
            String[] commandTokens = scanner.nextLine().split("\\s+");
            String command = commandTokens[0];
            int enemyRow = Integer.parseInt(commandTokens[1]);
            int enemyCol = Integer.parseInt(commandTokens[2]);
            matrix[enemyRow][enemyCol] = "S";
            matrix[parisRow][parisCol] = "-";
            usedEnergy++;
            switch (command) {
                case "up":
                    if(parisRow > 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if(parisRow < matrix.length - 1) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if(parisCol > 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if(parisCol < matrix[parisRow].length - 1) {
                        parisCol++;
                    }
                    break;
            }
            if(matrix[parisRow][parisCol].equals("S")) {
                usedEnergy += 2;
            } else if(matrix[parisRow][parisCol].equals("H")) {
                matrix[parisRow][parisCol] = "-";
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", (e - usedEnergy));
                break;
            }
            if(usedEnergy >= e) {
                matrix[parisRow][parisCol] = "X";
                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                break;
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(String.join("", matrix[row]));
        }
    }
}
