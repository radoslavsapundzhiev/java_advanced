import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] comandTokens = scanner.nextLine().split("\\s+");
            String comandNumber = comandTokens[0];
            switch (comandNumber){
                case "1":
                    stack.push(Integer.parseInt(comandTokens[1]));
                    break;
                case "2":
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                case "3":
                    if(!stack.isEmpty()){
                        System.out.println(Collections.max(stack));
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
