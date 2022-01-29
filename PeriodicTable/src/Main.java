import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> elements = new TreeSet<>();
        int inputRows = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < inputRows; i++) {
            String[] currentElements = scanner.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(currentElements));
        }
        elements.stream().forEach(e -> System.out.print(e + " "));
    }
}
