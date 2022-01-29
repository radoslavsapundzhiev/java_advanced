import java.sql.SQLOutput;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> usernames = new LinkedHashSet<>();
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String currentUsername = scanner.nextLine();
            usernames.add(currentUsername);
        }
        usernames.forEach(System.out::println);
    }
}
