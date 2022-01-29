import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        List<String> names = Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());
        Predicate<String> isLessOrEqual = name -> name.length() <= length;
        names = names.stream()
                .filter(isLessOrEqual)
                .collect(Collectors.toList());
        names.forEach(System.out::println);
    }
}
