package fr.univavignon.pokedex.api;

/**
 *  Factory creating Pokedex instances.
 *
 * @author an
 */
public class PokedexFactory implements IPokedexFactory {
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
