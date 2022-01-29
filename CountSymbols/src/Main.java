import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> symbolsCount = new TreeMap<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if(!symbolsCount.containsKey(currentSymbol)) {
                symbolsCount.put(currentSymbol, 1);
            } else {
                int currentCount = symbolsCount.get(currentSymbol);
                symbolsCount.put(currentSymbol, currentCount + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry: symbolsCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
