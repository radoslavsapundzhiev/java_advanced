import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner
                .nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] inputTokens = input.split("\\s+");
            String command = inputTokens[0];
            String criteria = inputTokens[1];
            String parameter = inputTokens[2];
            if(command.equals("Remove")) {
                if(criteria.equals("StartsWith")) {
                    guests = guests.stream()
                            .filter(g -> !g.startsWith(parameter))
                            .collect(Collectors.toList());
                } else if(criteria.equals("EndsWith")) {
                    guests = guests.stream()
                            .filter(g -> !g.endsWith(parameter))
                            .collect(Collectors.toList());
                } else if(criteria.equals("Length")) {
                    int par = Integer.parseInt(parameter);
                    guests = guests.stream()
                            .filter(g -> g.length() != par)
                            .collect(Collectors.toList());
                }
            } else if(command.equals("Double")) {
                if(criteria.equals("StartsWith")) {
                    List<String> guestsToDouble = guests.stream()
                            .filter(g -> g.startsWith(parameter))
                            .collect(Collectors.toList());
                    guests.addAll(guestsToDouble);
                } else if(criteria.equals("EndsWith")) {
                    List<String> guestsToDouble = guests.stream()
                            .filter(g -> g.endsWith(parameter))
                            .collect(Collectors.toList());
                    guests.addAll(guestsToDouble);
                } else if(criteria.equals("Length")) {
                    int par = Integer.parseInt(parameter);
                    List<String> guestsToDouble = guests.stream()
                            .filter(g -> g.length() == par)
                            .collect(Collectors.toList());
                    guests.addAll(guestsToDouble);
                }
            }
            input = scanner.nextLine();
        }
        Collections.sort(guests);
        if(guests.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.print(String.join(", ", guests));
            System.out.println(" are going to the party!");
        }
    }
}
