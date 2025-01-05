package pokemonTrainerTwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Trainer> trainers = new ArrayList<>();

        while (!command.equals("Tournament")) {
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
            String[] info = command.split(" ");
            String trainerName = info[0];
            String pokemonName = info[1];
            String element = info[2];
            int health= Integer.parseInt(info[3]);
            Pokemon pokemon = new Pokemon(pokemonName,element,health);
            Trainer trainer = getTrainerByName(trainers, trainerName);
            trainer.getPokemons().add(pokemon);
            trainers.add(trainer);
            command = scanner.nextLine();
        }

        String elementToCompare = scanner.nextLine();

        while(!elementToCompare.equals("End")){
            boolean hasElement = false;
            for (Trainer trainer : trainers) {
                for (Pokemon pokemon : trainer.getPokemons()) {
                    if(pokemon.getElement().equals(elementToCompare)){
                        trainer.setNumberOfBadges(trainer.getNumberOfBadges()+1);
                        hasElement=true;
                        break;
                    }
                }
                if(!hasElement){
                    for (Pokemon pokemon : trainer.getPokemons()) {
                        pokemon.setHealth(pokemon.getHealth()-10);
                        if(pokemon.getHealth()<=0){
                            trainer.getPokemons().remove(pokemon);
                        }
                    }
                }
            }

            elementToCompare=scanner.nextLine();
        }

        //sorted by the amount of badges they have in descending order (if two trainers have the same amount of badges,
        // they should be sorted by order of appearance in the input) in the format "{TrainerName} {Badges} {NumberOfPokemon}".

        trainers.stream().sorted(Comparator.comparing(trainer->trainer.getNumberOfBadges()));
        trainers.reversed();
        //{TrainerName} {Badges} {NumberOfPokemon}".

        for (Trainer trainer : trainers) {
            System.out.printf("%s %d %d\n", trainer.getName(), trainer.getNumberOfBadges(), trainer.getPokemons().size());
        }
    }

    public static Trainer getTrainerByName (List<Trainer> trainers, String name){
        for (Trainer trainer : trainers) {
            if(trainer.getName().equals(name)){
                return trainer;
            }
        }
        Trainer trainer = new Trainer (name);
        return trainer;
    }
}
