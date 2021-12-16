package T6DefiningClasses.exercises.PokemonTrainer_06;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void addBadge() {
        this.badges += 1;
    }

    public int getBadges() {
        return badges;
    }

    @Override
    public String toString() {
        //"{TrainerName} {Badges} {NumberOfPokemon}".
        return this.name + " " + this.badges + " " + this.pokemonList.size();
    }
}
