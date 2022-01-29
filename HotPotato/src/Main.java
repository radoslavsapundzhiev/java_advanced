import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < children.length; i++) {
            queue.offer(children[i]);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < n ; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
