import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] inputTokens = input.split("\\s+");
            String ip = inputTokens[0].split("=")[1];
            String user = inputTokens[2].split("=")[1];

            if(!userLogs.containsKey(user)) {
                LinkedHashMap<String, Integer> ips = new LinkedHashMap<>();
                userLogs.put(user, ips);
            }

            LinkedHashMap<String, Integer> currentIps = userLogs.get(user);
            if(!currentIps.containsKey(ip)) {
                currentIps.put(ip, 0);
            }

            int currentIpCount = currentIps.get(ip);
            currentIps.put(ip, currentIpCount + 1);

            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> userEntry: userLogs.entrySet()) {
            int ipsCount = userEntry.getValue().size();
            System.out.println(userEntry.getKey() + ": ");
            for (Map.Entry<String, Integer> ipEntry: userEntry.getValue().entrySet()) {
                if(ipsCount == 1) {
                    System.out.println(ipEntry.getKey() + " => " + ipEntry.getValue() + ".");
                } else {
                    System.out.print(ipEntry.getKey() + " => " + ipEntry.getValue() + ", ");
                }
                ipsCount--;
            }

        }
    }
}
