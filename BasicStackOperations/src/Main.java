import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int s = Integer.parseInt(numbers[1]);
        String x = numbers[2];
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(input[i]);
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if(stack.isEmpty()){
            System.out.println(0);
        } else {
            if(stack.contains(x)){
                System.out.println("true");
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
