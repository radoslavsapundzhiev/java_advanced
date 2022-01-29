import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] inputData = input.split("-");
            String name = inputData[0];
            String phone = inputData[1];
            phonebook.put(name, phone);
            input = scanner.nextLine();
        }
        String inputName = scanner.nextLine();
        while (!inputName.equals("stop")) {
            if(phonebook.containsKey(inputName)) {
                System.out.println(inputName + " -> " + phonebook.get(inputName));
            } else {
                System.out.printf("Contact %s does not exist.%n", inputName);
            }
            inputName = scanner.nextLine();
        }
    }
}
