import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> readyCocktails = new TreeMap<>();
        List<Integer> firstRow = Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondRow = Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> queue = new ArrayDeque<>(firstRow);
        Collections.reverse(secondRow);
        ArrayDeque<Integer> stack = new ArrayDeque<>(secondRow);
        Map<Integer, String> cocktails = getCocktails();
        while (!queue.isEmpty() && !stack.isEmpty()) {
            int currentBucket = queue.peek();
            int currentLevel = stack.peek();
            if(currentBucket == 0) {
                queue.poll();
                continue;
            }
            int mixedCocktailLevel = currentBucket * currentLevel;
            if(cocktails.containsKey(mixedCocktailLevel)) {
                String cocktailName = cocktails.get(mixedCocktailLevel);
                if(!readyCocktails.containsKey(cocktailName)) {
                    readyCocktails.put(cocktailName, 0);
                }
                readyCocktails.put(cocktailName, readyCocktails.get(cocktailName) + 1);
                queue.poll();
                stack.pop();
            } else {
                stack.pop();
                currentBucket += 5;
                queue.poll();
                queue.offer(currentBucket);
            }
        }
        if(readyCocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if(!queue.isEmpty()) {
                List<Integer> ingredients = new ArrayList<>(queue);
                int sum = ingredients.stream()
                        .mapToInt(Integer::intValue)
                        .sum();
                System.out.printf("Ingredients left: %d%n", sum);
        }

        for (Map.Entry<String, Integer> entry: readyCocktails.entrySet()) {
            System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static Map<Integer, String> getCocktails() {
        Map<Integer, String> cocktails = new HashMap<>();
        cocktails.put(150, "Pear Sour");
        cocktails.put(250, "The Harvest");
        cocktails.put(300, "Apple Hinny");
        cocktails.put(400, "High Fashion");
        return cocktails;
    }
}
