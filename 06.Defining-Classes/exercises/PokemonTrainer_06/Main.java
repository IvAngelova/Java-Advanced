package T6DefiningClasses.exercises.PokemonTrainer_06;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).getPokemonList().add(pokemon);

            input = scan.nextLine();
        }

        String elementPokemon = scan.nextLine();
        while (!elementPokemon.equals("End")) {

            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                boolean isFound = false;
                for (Pokemon pokemon : entry.getValue().getPokemonList()) {
                    if (pokemon.getElement().equals(elementPokemon)) {
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    entry.getValue().addBadge();
                } else {
                    for (int i = 0; i < entry.getValue().getPokemonList().size(); i++) {
                        Pokemon currPokemon = entry.getValue().getPokemonList().get(i);
                        currPokemon.loseHealth();
                        if (currPokemon.getHealth() <= 0) {
                            entry.getValue().getPokemonList().remove(currPokemon);
                        }
                    }
                }
            }


            elementPokemon = scan.nextLine();
        }

        trainers.values().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getBadges(), e1.getBadges()))
                .forEach(trainer -> System.out.println(trainer.toString()));

    }
}
