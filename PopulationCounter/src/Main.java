import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] inputTokens = input.split("\\|");
            String city = inputTokens[0];
            String country = inputTokens[1];
            long population = Long.parseLong(inputTokens[2]);
            if(!countries.containsKey(country)) {
                Map<String, Long> cities = new LinkedHashMap<>();
                countries.put(country, cities);
            }
            Map<String, Long> currentCities = countries.get(country);
            if(!currentCities.containsKey(city)) {
                currentCities.put(city, 0L);
            }
            currentCities.put(city, population);
            input = scanner.nextLine();
        }
        countries
                .entrySet()
                .stream()
                .sorted((a,b) -> {
                    long first = a.getValue().values().stream().mapToLong(Long::longValue).sum();
                    long second = b.getValue().values().stream().mapToLong(Long::longValue).sum();
                    return Long.compare(second, first);
        }).forEach(e -> {
            long currentSumPopulation = e.getValue().values().stream().mapToLong(Long::longValue).sum();
            System.out.println(e.getKey() + " (total population: " + currentSumPopulation + ")");
            e.getValue()
                    .entrySet()
                    .stream()
                    .sorted((c, d) -> {
                        return d.getValue().compareTo(c.getValue());
                    })
                    .forEach(p -> {
                        System.out.println("=>" + p.getKey() + ": " + p.getValue());
                    });
        });
    }
}
