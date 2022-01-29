import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resources = new LinkedHashMap<>();
        String input = scanner.nextLine();
        int count = 0;
        String resource = "";
        int quantity = 0;
        while (!input.equals("stop")) {
            if(count % 2 == 0) {
                resource = input;
            } else {
                quantity = Integer.parseInt(input);
                if(!resources.containsKey(resource)) {
                    resources.put(resource, quantity);
                } else {
                    int currentQuantity = resources.get(resource);
                    resources.put(resource, currentQuantity + quantity);
                }
            }
            count++;
            input = scanner.nextLine();
        }
        resources.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " -> " + e.getValue());
        });
    }
}
