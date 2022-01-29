import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] tokens = scanner.nextLine().split("\\s+");
        for (int i = tokens.length - 1; i >= 0; i--) {
            stack.push(tokens[i]);
        }
        int sum = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()){
            String operator = stack.pop();
            int operand = Integer.parseInt(stack.pop());
            if(operator.equals("+")){
                sum += operand;
            } else if(operator.equals("-")){
                sum -= operand;
            }
        }
        System.out.println(sum);
    }
}
