import java.util.*;
        import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, TreeMap<String, Integer>> userLogs = new TreeMap<>();
        int numberOfLogLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfLogLines; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String ip = data[0];
            String name = data[1];
            int duration = Integer.parseInt(data[2]);
            if(!userLogs.containsKey(name)) {
                TreeMap<String, Integer> ips = new TreeMap<>();
                userLogs.put(name, ips);
            }
            TreeMap<String, Integer> currentIps = userLogs.get(name);
            if(!currentIps.containsKey(ip)) {
                currentIps.put(ip, 0);
            }
            int currentDuration = currentIps.get(ip);
            currentIps.put(ip, currentDuration + duration);
        }
        userLogs
                .entrySet()
                .forEach(e -> {
                    int currentSumOfDuration = e.getValue()
                            .values().stream()
                            .mapToInt(Integer::intValue)
                            .sum();
                    System.out.print(e.getKey() + ": " + currentSumOfDuration + " ");
                    String result = String.join(", ", e.getValue().keySet());
                    System.out.println("[" + result + "]");
                });
    }
}
