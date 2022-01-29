import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //Predicate<Integer> isDivisible = num -> num %
        for (int i = 1; i <= n; i++) {
            boolean found = true;
            for (int j = 0; j < numbers.size(); j++) {
                if(i % numbers.get(j) != 0) {
                    found = false;
                    break;
                }
            }
            if(found) {
                System.out.print(i + " ");
            }
        }
    }
}
