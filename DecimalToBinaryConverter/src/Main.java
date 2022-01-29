import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int decimal = scanner.nextInt();
        scanner.nextLine();
        if(decimal == 0){
            System.out.println(0);
        }else{
            while (decimal != 0){
                stack.push(decimal % 2);
                decimal /= 2;
            }
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
    }
}
