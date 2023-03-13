package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokemonTrainerFactoryTest {
    IPokemonTrainerFactory mockIPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
    IPokedexFactory mockIPokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokedex mockIPokedex = Mockito.mock(IPokedex.class);
    PokemonTrainer mockPokemonTrainer = new PokemonTrainer("Anthony", Team.VALOR, mockIPokedex);


    @Test
    public void ShouldCreatePokemonTrainer()
    {
        when(mockIPokemonTrainerFactory.createTrainer("Anthony", Team.VALOR, mockIPokedexFactory)).thenReturn(mockPokemonTrainer);
        PokemonTrainer pokemonTrainer = mockIPokemonTrainerFactory.createTrainer("Anthony",  Team.VALOR, mockIPokedexFactory);
        assertEquals(mockPokemonTrainer, pokemonTrainer);
    }
}