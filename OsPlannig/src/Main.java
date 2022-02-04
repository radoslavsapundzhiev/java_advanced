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
        ArrayDeque<Integer> tasks = new ArrayDeque<>(firstRow);
        List<Integer> secondRow = Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> threads = new ArrayDeque<>(secondRow);
        int taskToKill = Integer.parseInt(scanner.nextLine());
        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int currentTask = tasks.peek();
            int currentThread = threads.peek();
            if(currentTask == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n", currentThread, currentTask);
                break;
            }
            if(currentThread >= currentTask) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }
        }
        threads.forEach(e -> System.out.print(e + " "));
    }
}
