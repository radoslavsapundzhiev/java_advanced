import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> cardPoints = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] inputParts = input.split(":\\s+");
            String currentName = inputParts[0];
            String[] currentCards = inputParts[1].split(",\\s+");
            if(!cardPoints.containsKey(currentName)) {
                Set<String> currentSet = new HashSet<>();
                currentSet.addAll(Arrays.asList(currentCards));
                cardPoints.put(currentName, currentSet);
            } else {
                Set<String> currentSet = cardPoints.get(currentName);
                currentSet.addAll(Arrays.asList(currentCards));
                cardPoints.put(currentName, currentSet);
            }
            input = scanner.nextLine();
        }
        cardPoints.entrySet().forEach(e -> {
            int points = getCardPoints(e.getValue());
            System.out.println(e.getKey() + ": " + points);
        });
    }

    private static int getCardPoints(Set<String> value) {
        int points = 0;
        for (String card: value) {
            char power = card.charAt(0);
            char type = card.charAt(1);

            if(card.startsWith("10")) {
                power = 10;
                type = card.charAt(2);
                points += power * pointForSymbolMap().get(type);
            } else {
                points += pointForSymbolMap().get(power) * pointForSymbolMap().get(type);
            }
        }
        return points;
    }

    private static Map<Character, Integer> pointForSymbolMap() {
        Map<Character, Integer> pointMap = new HashMap<>() {
            {
                put('2', 2);
                put('3', 3);
                put('4', 4);
                put('5', 5);
                put('6', 6);
                put('7', 7);
                put('8', 8);
                put('9', 9);
                put('J', 11);
                put('Q', 12);
                put('K', 13);
                put('A', 14);
                put('S', 4);
                put('H', 3);
                put('D', 2);
                put('C', 1);
            }};
        return pointMap;
    }
}
