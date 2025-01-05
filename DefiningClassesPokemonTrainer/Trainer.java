package DefiningClassesPokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trainer {
    private String name;
    private int numberOfBadges;
    List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        pokemonList = new ArrayList<>();
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public String getName() {
        return name;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public String toString() {
        //"{TrainerName} {Badges} {NumberOfPokemon}".
        String name = this.name;
        int badge = this.numberOfBadges;
        int size = this.pokemonList.size();
        return String.format("%s %d %d", name, badge, size);
    }
}