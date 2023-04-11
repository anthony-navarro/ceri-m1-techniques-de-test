package fr.univavignon.pokedex.api;

/**
 * Factory creating PokemonTrainer instances.
 *
 * @author an
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(PokemonMetadataProvider.getPokemonMetadataProvider(), new PokemonFactory());
        return new PokemonTrainer(name, team, pokedex);
    }
}
