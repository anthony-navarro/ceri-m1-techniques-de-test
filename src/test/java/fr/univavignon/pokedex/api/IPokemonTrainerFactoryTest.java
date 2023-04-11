package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonTrainerFactoryTest {
    IPokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory();
    IPokemonFactory pokemonFactory = new PokemonFactory();
    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonMetadataProvider pokemonMetadataProvider = PokemonMetadataProvider.getPokemonMetadataProvider();
    IPokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
    PokemonTrainer pokemonTrainer;
    PokemonTrainer pokemonTrainerTest;


    @BeforeEach
    public void setup() throws PokedexException {
        pokemonTrainer = new PokemonTrainer("Anthony", Team.VALOR, pokedex);
        pokemonTrainerTest = pokemonTrainerFactory.createTrainer("Anthony",  Team.VALOR, pokedexFactory);

    }

    @Test
    public void ShouldCreatePokemonTrainer()
    {
        assertEquals(pokemonTrainer.getName(), pokemonTrainerTest.getName());
        assertEquals(pokemonTrainer.getTeam(), pokemonTrainerTest.getTeam());
        assertEquals(pokemonTrainer.getPokedex().getClass(), pokemonTrainerTest.getPokedex().getClass());
    }
}