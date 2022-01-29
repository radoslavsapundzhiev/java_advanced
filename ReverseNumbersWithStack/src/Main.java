import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String n : numbers) {
            stack.push(n);
        }
        for (String s : stack) {
            System.out.print(s + " ");
        }
    }
}
