import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstRow = Arrays.stream(scanner
                .nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> effects = new ArrayDeque<>(firstRow);
        List<Integer> secondRow = Arrays.stream(scanner
                .nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(secondRow);
        ArrayDeque<Integer> casings = new ArrayDeque<>(secondRow);
        Map<Integer, String> materials = getMaterials();
        Map<String, Integer> bombs = new TreeMap<>();
        while (!effects.isEmpty() && !casings.isEmpty()) {
            int currentEffect = effects.peek();
            int currentCasing = casings.peek();
            int sum = currentEffect + currentCasing;
            if(materials.containsKey(sum)) {
                String currentMaterial = materials.get(sum);
                if(!bombs.containsKey(currentMaterial)) {
                    bombs.put(currentMaterial, 0);
                }
                bombs.put(currentMaterial, bombs.get(currentMaterial) + 1);
                effects.poll();
                casings.pop();
            } else {
                currentCasing -= 5;
                casings.pop();
                casings.push(currentCasing);
            }

            if(hasAtLeastThreeOfEachBomb(bombs)){
                break;
            }
        }
        if(hasAtLeastThreeOfEachBomb(bombs)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if(effects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            List<String> effectsAsStrings = effects.stream()
                    .map(e -> e.toString())
                    .collect(Collectors.toList());
            System.out.printf("Bomb Effects: %s%n", String.join(", ", effectsAsStrings));
        }

        if(casings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            List<String> casingsAsStrings = casings.stream()
                    .map(e -> e.toString())
                    .collect(Collectors.toList());
            System.out.printf("Bomb Casings: %s%n", String.join(", ", casingsAsStrings));
        }

        int cherryBombs = 0;
        if(bombs.containsKey("Cherry Bombs")){
            cherryBombs = bombs.get("Cherry Bombs");
        }

        System.out.println("Cherry Bombs: " + cherryBombs);

        int daturaBombs = 0;
        if(bombs.containsKey("Datura Bombs")) {
            daturaBombs = bombs.get("Datura Bombs");
        }

        System.out.println("Datura Bombs: " + daturaBombs);

        int smokeDecoyBombs = 0;
        if(bombs.containsKey("Smoke Decoy Bombs")) {
            smokeDecoyBombs = bombs.get("Smoke Decoy Bombs");
        }

        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombs);
    }

    private static boolean hasAtLeastThreeOfEachBomb(Map<String, Integer> bombs) {
        if(bombs.size() < 3) {
            return false;
        }

        for (Map.Entry<String, Integer> entry: bombs.entrySet()) {
            if(entry.getValue() < 3) {
                return false;
            }
        }

        return true;
    }

    private static Map<Integer, String> getMaterials() {
        Map<Integer, String> materials = new HashMap<>();
        materials.put(40, "Datura Bombs");
        materials.put(60, "Cherry Bombs");
        materials.put(120, "Smoke Decoy Bombs");
        return materials;
    }
}
