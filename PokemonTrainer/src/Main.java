import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        while (true) {
            String[] lineTokens = scanner.nextLine().split("\\s+");
            if(lineTokens[0].equals("Tournament")) {
                break;
            }
            String trainerName = lineTokens[0];
            String pokemonName = lineTokens[1];
            String pokemonElement = lineTokens[2];
            int pokemonHealth = Integer.parseInt(lineTokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if(!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer(trainerName));
            }
            Trainer trainer = trainers.get(trainerName);
            List<Pokemon> pokemons = trainer.getPokemons();
            pokemons.add(pokemon);
        }
        String element = scanner.nextLine();
        while (!element.equals("End")) {
            for (Map.Entry<String,Trainer> entry: trainers.entrySet()) {
                List<String> currentPokemonElements = entry
                        .getValue()
                        .getPokemons()
                        .stream().map(p -> p.getElement())
                        .collect(Collectors.toList());
                List<Pokemon> pokemons = entry.getValue().getPokemons();
                Trainer trainer = entry.getValue();
                if(currentPokemonElements.contains(element)) {
                    entry.getValue().setNumberOfBadges(entry.getValue().getNumberOfBadges() + 1);
                } else {
                    pokemons.forEach(p -> {
                        p.setHealth(p.getHealth() - 10);
                    });
                    removeDeadPokemonsFromTrainer(trainer);
                }
            }
            element = scanner.nextLine();
        }
        trainers.entrySet().stream()
                .sorted((e1, e2) -> {
                    return e2.getValue().getNumberOfBadges() - e1.getValue().getNumberOfBadges();
                })
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue().getNumberOfBadges() + " " + e.getValue().getPokemons().size()));
    }

    private static void removeDeadPokemonsFromTrainer(Trainer trainer) {
        List<Pokemon> pokemons = trainer.getPokemons();
        List<Pokemon> updatedPokemons = pokemons.stream()
                .filter(p -> p.isAlive())
                .collect(Collectors.toList());
        trainer.setPokemons(updatedPokemons);
    }
}
