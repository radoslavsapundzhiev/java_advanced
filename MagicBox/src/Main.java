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
        ArrayDeque<Integer> firstBox = new ArrayDeque<>(firstRow);
        //stack
        List<Integer> secondRow = Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(secondRow);
        ArrayDeque<Integer> secondBox = new ArrayDeque<>(secondRow);
        List<Integer> claimedItems = new ArrayList<>();
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int currentFirst = firstBox.peek();
            int currentSecond = secondBox.peek();
            int sum = currentFirst + currentSecond;
            if(sum % 2 == 0) {
                claimedItems.add(sum);
                firstBox.poll();
                secondBox.pop();
            } else {
                secondBox.pop();
                firstBox.offer(currentSecond);
            }
        }

        if(firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }

        if(secondBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        int sumOfClaimedItems = claimedItems.stream()
                .mapToInt(Integer::intValue)
                .sum();
        if(sumOfClaimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", sumOfClaimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d%n", sumOfClaimedItems);
        }
    }
}
