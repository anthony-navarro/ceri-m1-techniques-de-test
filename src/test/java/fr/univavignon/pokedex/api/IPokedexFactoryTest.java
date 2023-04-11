package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokedexFactoryTest
{
    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonFactory pokemonFactory = new PokemonFactory();
    IPokemonMetadataProvider pokemonMetadataProvider = PokemonMetadataProvider.getPokemonMetadataProvider();
    IPokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);

    @Test
    public void shouldCreatePokedex()
    {
        assertEquals(pokedex.getClass(),
                pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory).getClass());
    }
}