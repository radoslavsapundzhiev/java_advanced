import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        Consumer<String[]> printNames = arr -> {
            for (String name: arr) {
                System.out.println("Sir " + name);
            }
        };

        printNames.accept(names);
    }
}
