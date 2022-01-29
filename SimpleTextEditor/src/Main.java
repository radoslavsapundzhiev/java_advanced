import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> textHistory = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandTokens = scanner.nextLine().split("\\s+");
            String command = commandTokens[0];
            switch (command) {
                case "1":
                    String argument = commandTokens[1];
                    textHistory.push(text.toString());
                    text.append(argument);
                    break;
                case "2":
                    int count = Integer.parseInt(commandTokens[1]);
                    textHistory.push(text.toString());
                    text.delete(text.length() - count, text.length());
                    break;
                case "3":
                    int index = Integer.parseInt(commandTokens[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    StringBuilder lastTextState = new StringBuilder(textHistory.pop());
                    text = lastTextState;
                    break;
                default:
                    break;
            }
        }
    }
}
