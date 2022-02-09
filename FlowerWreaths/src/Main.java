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
        Collections.reverse(firstRow);
        ArrayDeque<Integer> lilies = new ArrayDeque<>(firstRow);
        List<Integer> secondRow = Arrays.stream(scanner
                .nextLine()
                .split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> roses = new ArrayDeque<>(secondRow);
        int wreaths = 0;
        List<Integer> leftFlowers = new ArrayList<>();
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int currentLilie = lilies.peek();
            int currentRose = roses.peek();
            int sum = currentLilie + currentRose;
            if(sum == 15) {
                wreaths++;
                lilies.pop();
                roses.poll();
            } else if (sum > 15) {
                currentLilie -= 2;
                lilies.pop();
                lilies.push(currentLilie);
            } else {
                lilies.pop();
                roses.poll();
                leftFlowers.add(sum);
            }
        }
        int sumLeftFlowers = leftFlowers.stream().mapToInt(Integer::intValue).sum();
        wreaths += sumLeftFlowers / 15;
        if(wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", (5 - wreaths));
        }
    }
}
