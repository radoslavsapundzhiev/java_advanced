import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //queue
        List<Integer> firstRow = Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> liquids = new ArrayDeque<>(firstRow);
        //stack
        List<Integer> secondRow = Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(secondRow);
        ArrayDeque<Integer> ingredients = new ArrayDeque<>(secondRow);
        Map<Integer, String> foodValues = getFoodValues();
        Map<String, Integer> readyFoods = new TreeMap<>();
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currentLiquid = liquids.peek();
            int currentIngredient = ingredients.peek();
            int sum = currentLiquid + currentIngredient;
            if(foodValues.containsKey(sum)) {
                liquids.poll();
                ingredients.pop();
                String food = foodValues.get(sum);
                if(!readyFoods.containsKey(food)) {
                    readyFoods.put(food, 0);
                }
                readyFoods.put(food, readyFoods.get(food) + 1);
            } else {
                liquids.poll();
                currentIngredient += 3;
                ingredients.pop();
                ingredients.push(currentIngredient);
            }
        }
        if(readyFoods.size() == 4) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if(liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            List<String> liquidsStr = liquids.stream()
                    .map(l -> l.toString()).collect(Collectors.toList());
            System.out.println("Liquids left: " + String.join(", ", liquidsStr));
        }

        if(ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            List<String> ingredientsStr = ingredients.stream()
                    .map(i -> i.toString()).collect(Collectors.toList());
            System.out.println("Ingredients left: " + String.join(", ", ingredientsStr));
        }

        int breads = 0;
        if(readyFoods.containsKey("Bread")) {
            breads = readyFoods.get("Bread");
        }
        System.out.printf("Bread: %d%n", breads);

        int cakes = 0;
        if(readyFoods.containsKey("Cake")) {
            cakes = readyFoods.get("Cake");
        }
        System.out.printf("Cake: %d%n", cakes);

        int fruitPies = 0;
        if(readyFoods.containsKey("Fruit Pie")) {
            fruitPies = readyFoods.get("Fruit Pie");
        }
        System.out.printf("Fruit Pie: %d%n", fruitPies);

        int pastries = 0;
        if(readyFoods.containsKey("Pastry")) {
            pastries = readyFoods.get("Pastry");
        }
        System.out.printf("Pastry: %d%n", pastries);
    }

    private static Map<Integer, String> getFoodValues() {
        Map<Integer, String> foodValues = new HashMap<>();
        foodValues.put(25, "Bread");
        foodValues.put(50, "Cake");
        foodValues.put(75, "Pastry");
        foodValues.put(100, "Fruit Pie");
        return foodValues;
    }
}
