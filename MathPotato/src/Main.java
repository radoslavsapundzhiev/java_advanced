import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < children.length; i++) {
            queue.offer(children[i]);
        }
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n ; i++) {
                queue.offer(queue.poll());
            }
            if(isPrime(cycle)){
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }
    public static boolean isPrime(int num) {
        if(num > 1) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
