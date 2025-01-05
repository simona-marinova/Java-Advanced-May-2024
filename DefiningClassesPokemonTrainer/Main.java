package DefiningClassesPokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String instruction = scanner.nextLine();
        List<Trainer> trainers = new ArrayList<>();

        while (!instruction.equals("Tournament")) {
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
            String[] commands = instruction.split(" ");
            String trainerName = commands[0];
            String pokemonName = commands[1];
            String element = commands[2];
            int health = Integer.parseInt(commands[3]);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            Trainer trainer = getTrainerByName(trainerName, trainers);
            trainer.addPokemon(pokemon);
            instruction = scanner.nextLine();
        }
        String elementsInfo = scanner.nextLine();

        while (!elementsInfo.equals("End")) {
            //"Fire", "Water", and "Electricity
            receiveBadgesOrLoseHealth(elementsInfo, trainers);
            elementsInfo = scanner.nextLine();

        }

     Collections.sort(trainers, Comparator.comparing(Trainer::getNumberOfBadges).reversed());

        for (Trainer trainer : trainers) {
            System.out.println(trainer);
        }

    }

    public static void receiveBadgesOrLoseHealth(String elementsInfo, List<Trainer> trainers) {

        for (Trainer trainer : trainers) {
            String trainerName = trainer.getName();
            List<Pokemon> pokemons = trainer.getPokemonList();
            boolean hasElement = false;
            for (Pokemon pokemon : pokemons) {
                if (pokemon.getElement().equals(elementsInfo)) {
                    hasElement = true;
                }
            }
            if (hasElement) {
                int oldValue = trainer.getNumberOfBadges();
                trainer.setNumberOfBadges(oldValue + 1);
                continue;
            } else {
                List<Pokemon> pokemonList = trainer.getPokemonList();
                for (Pokemon pokemon : pokemonList) {
                    int currentHealth = pokemon.getHealth();
                    pokemon.setHealth(currentHealth - 10);
                    int health = pokemon.getHealth();
                    if (health <= 0) {
                        pokemonList.remove(pokemon);
                        if(pokemonList.size()==0){
                            break;
                        }
                    }
                }
            }
        }
    }

    private static Trainer getTrainerByName(String trainerName, List<Trainer> trainers) {
        for (Trainer trainer : trainers) {
            String name = trainer.getName();
            if (trainerName.equals(name)) {
                return trainer;
            }
        }
        Trainer trainer = new Trainer(trainerName);
        trainers.add(trainer);
        return trainer;

    }
}


