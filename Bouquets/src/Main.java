import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstRow = Arrays.stream(scanner //tulips[stack]
                .nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(firstRow);
        ArrayDeque<Integer> tulips = new ArrayDeque<>(firstRow);
        List<Integer> secondRow = Arrays.stream(scanner //daffodils[queue]
                .nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> daffodils = new ArrayDeque<>(secondRow);
        int bouquets = 0;
        int leftFlowers = 0;
        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int currentTulips = tulips.peek();
            int currentDaffodils = daffodils.peek();
            int sum = currentTulips + currentDaffodils;
            while (sum > 15) {
                currentTulips -= 2;
                sum = currentTulips + currentDaffodils;
            }
            if(sum == 15) {
                bouquets++;
            } else {
                leftFlowers += sum;
            }
            tulips.pop();
            daffodils.poll();
        }
        bouquets += leftFlowers / 15;
        if(bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.%n", (5 - bouquets));
        }
    }
}
