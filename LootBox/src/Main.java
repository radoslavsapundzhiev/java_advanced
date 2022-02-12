import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstRow = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        for (int i = 0; i < firstRow.length; i++) {
            firstBox.offer(Integer.parseInt(firstRow[i]));
        }
        String[] secondRow = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        for (int i = 0; i < secondRow.length; i++) {
            secondBox.push(Integer.parseInt(secondRow[i]));
        }
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
                firstBox.offer(currentFirst);
            }
        }

        if(firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if(secondBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        int sumOfClaimedItems = claimedItems.stream().mapToInt(Integer::intValue).sum();

        if(sumOfClaimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", sumOfClaimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", sumOfClaimedItems);
        }

    }
}
