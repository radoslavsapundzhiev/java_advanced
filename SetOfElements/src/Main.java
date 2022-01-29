import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstSetSize = dimensions[0];
        int secondSetSize = dimensions[1];
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < firstSetSize; i++) {
            int currentElement = Integer.parseInt(scanner.nextLine());
            firstSet.add(currentElement);
        }
        for (int i = 0; i < secondSetSize; i++) {
            int currentElement = Integer.parseInt(scanner.nextLine());
            secondSet.add(currentElement);
        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
