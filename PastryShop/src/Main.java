import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstRow = Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> liquids = new ArrayDeque<>(firstRow);
        List<Integer> secondRow = Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(secondRow);
        ArrayDeque<Integer> ingredients = new ArrayDeque<>(secondRow);
        Map<Integer, String> foods = getFoods();
        Map<String, Integer> readyFoods = new TreeMap<>();
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currentLiquid = liquids.peek();
            int currentIngredient = ingredients.peek();
            int currentSum = currentLiquid + currentIngredient;
            if(foods.containsKey(currentSum)) {
                String currentReadyFood = foods.get(currentSum);
                if(!readyFoods.containsKey(currentReadyFood)) {
                    readyFoods.put(currentReadyFood, 0);
                }
                readyFoods.put(currentReadyFood, readyFoods.get(currentReadyFood) + 1);
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                currentIngredient += 3;
                ingredients.pop();
                ingredients.push(currentIngredient);
            }
        }
        if(readyFoods.size() == 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if(liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            List<String> liquidsAsString = liquids
                    .stream()
                    .map(e -> e.toString())
                    .collect(Collectors.toList());
            System.out.println("Liquids left: " + String.join(", ", liquidsAsString));
        }

        if(ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            List<String> ingredientsAsString = ingredients
                    .stream()
                    .map(e -> e.toString())
                    .collect(Collectors.toList());
            System.out.println("Ingredients left: " + String.join(", ", ingredientsAsString));
        }
        int biscuits = 0;
        if(readyFoods.containsKey("Biscuit")) {
            biscuits = readyFoods.get("Biscuit");
        }
        System.out.printf("Biscuit: %d%n", biscuits);
        int cakes = 0;
        if(readyFoods.containsKey("Cake")) {
            cakes = readyFoods.get("Cake");
        }
        System.out.printf("Cake: %d%n", cakes);
        int pies = 0;
        if(readyFoods.containsKey("Pie")) {
            pies = readyFoods.get("Pie");
        }
        System.out.printf("Pie: %d%n", pies);
        int pastries = 0;
        if(readyFoods.containsKey("Pastry")) {
            pastries = readyFoods.get("Pastry");
        }
        System.out.printf("Pastry: %d%n", pastries);
    }

    public static Map<Integer, String> getFoods() {
        Map<Integer, String> foods = new HashMap<>();
        foods.put(25, "Biscuit");
        foods.put(50, "Cake");
        foods.put(75, "Pastry");
        foods.put(100, "Pie");
        return foods;
    }
}
