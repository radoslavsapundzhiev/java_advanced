import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        Consumer<String> printNames = name -> System.out.println(name);
        for (String name: names) {
            printNames.accept(name);
        }
    }
}
