import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double demagePerTurn = Double.parseDouble(scanner.nextLine());
        int playerRow = 7;
        int playerCol = 7;
        int[][] matrix = new int[15][15];
        int playerPoints = 18500;
        double heiganPoints = 3000000;
        ArrayDeque<String> spells = new ArrayDeque<>();
        String killingSpell = "";
        while (true) {
            String[] inputTokens = scanner.nextLine().split("\\s+");
            String spell = inputTokens[0];
            int spellRow = Integer.parseInt(inputTokens[1]);
            int spellCol = Integer.parseInt(inputTokens[2]);
            setDemage(spellRow, spellCol, matrix);
            boolean takeDamage = false;
            if(matrix[playerRow][playerCol] == 0) {
                if(playerRow - 1 >= 0 && matrix[playerRow - 1][playerCol] == 1) {
                    playerRow--;
                } else if(playerCol + 1 <= matrix.length - 1 && matrix[playerRow][playerCol + 1] == 1) {
                    playerCol++;
                } else if(playerRow + 1 <= matrix.length - 1 && matrix[playerRow + 1][playerCol] == 1) {
                    playerRow++;
                } else if(playerCol - 1 >= 0 && matrix[playerRow][playerCol - 1] == 1) {
                    playerCol--;
                } else {
                    takeDamage = true;
                }
            }
            heiganPoints -= demagePerTurn;
            if(heiganPoints <= 0) {
                break;
            }
            String previousSpell = "";
            if(!spells.isEmpty()) {
                previousSpell = spells.pop();
            }
            if((spell.equals("Cloud") && takeDamage)) {
                playerPoints -= 3500;
                if(playerPoints <= 0) {
                    killingSpell = spell;
                    break;
                }
            }

            if(!previousSpell.equals("")) {
                playerPoints -= 3500;
                if(playerPoints <= 0) {
                    killingSpell = spell;
                    break;
                }
            }

            if (spell.equals("Eruption") && takeDamage) {
                playerPoints -= 6000;
                if(playerPoints <= 0) {
                    killingSpell = spell;
                    break;
                }
            }
            if(spell.equals("Cloud") && takeDamage) {
                spells.push(spell);
            }
        }
        if(heiganPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        }
        if(playerPoints <= 0) {
            if(killingSpell.equals("Cloud")) {
                killingSpell = "Plague Cloud";
            }
            System.out.printf("Player: Killed by %s%n", killingSpell);
        } else {
            System.out.printf("Player: %d%n", playerPoints);
        }
        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
    }

    private static void setDemage(int spellRow, int spellCol, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = 1;
            }
        }
        for (int row = spellRow - 1; row <= spellRow + 1; row++) {
            for (int col = spellCol - 1; col <= spellCol + 1; col++) {
                if(row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix.length - 1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}
