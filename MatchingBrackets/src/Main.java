import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int start = 0;
        int end = 0;
        String[] tokens = scanner.nextLine().split("");
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("(")){
                stack.push(i);
            } else if(tokens[i].equals(")")) {
                start = stack.pop();
                end = i;
                for (int j = start; j <= end; j++) {
                    System.out.print(tokens[j]);
                }
                System.out.println();
            }
        }
    }
}
