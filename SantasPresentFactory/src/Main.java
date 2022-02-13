import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstRow = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> materials = new ArrayDeque<>();
        for (int i = 0; i < firstRow.length; i++) {
            materials.push(Integer.parseInt(firstRow[i]));
        }
        String[] secondRow = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> magicLevels = new ArrayDeque<>();
        for (int i = 0; i < secondRow.length; i++) {
            magicLevels.offer(Integer.parseInt(secondRow[i]));
        }
        Map<Integer, String> presents = getPresents();
        Map<String, Integer> readyPresents = new TreeMap<>();
        readyPresents.put("Doll", 0);
        readyPresents.put("Wooden train", 0);
        readyPresents.put("Teddy bear", 0);
        readyPresents.put("Bicycle", 0);
        while (!materials.isEmpty() && !magicLevels.isEmpty()) {
            int currentMaterial = materials.peek();
            int currentMagicLevel = magicLevels.peek();
            int multiplication = currentMaterial * currentMagicLevel;
            if(presents.containsKey(multiplication)) {
                String currentPresent = presents.get(multiplication);
                readyPresents.put(currentPresent, readyPresents.get(currentPresent) + 1);
                materials.pop();
                magicLevels.poll();
            } else if(multiplication < 0) {
                int sum = currentMaterial + currentMagicLevel;
                materials.pop();
                magicLevels.poll();
                materials.push(sum);
            } else if(multiplication > 0) {
                magicLevels.poll();
                materials.pop();
                currentMaterial += 15;
                materials.push(currentMaterial);
            }
            if(currentMaterial == 0) {
                materials.pop();
            }
            if(currentMagicLevel == 0) {
                magicLevels.poll();
            }
        }
        if((readyPresents.get("Doll") > 0 && readyPresents.get("Wooden train") > 0) ||
                (readyPresents.get("Teddy bear") > 0 && readyPresents.get("Bicycle") > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if(!materials.isEmpty()) {
            List<String> materialsAsStr = materials.stream().map(e -> e.toString()).collect(Collectors.toList());
            System.out.printf("Materials left: %s%n", String.join(", ", materialsAsStr));
        }

        if(!magicLevels.isEmpty()) {
            List<String> magicLevelsAsStr = magicLevels.stream().map(e -> e.toString()).collect(Collectors.toList());
            System.out.printf("Magic left: %s%n", String.join(", ", magicLevelsAsStr));
        }

        for (Map.Entry<String, Integer> entry: readyPresents.entrySet()) {
            if(entry.getValue() > 0) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        }
    }

    private static Map<Integer, String> getPresents() {
        Map<Integer, String> presents = new HashMap<>();
        presents.put(150, "Doll");
        presents.put(250, "Wooden train");
        presents.put(300, "Teddy bear");
        presents.put(400, "Bicycle");
        return presents;
    }
}
