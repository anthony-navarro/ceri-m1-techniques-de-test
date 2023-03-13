package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class IPokemonFactoryTest
{
    IPokemonFactory mockIPokemonFactory = Mockito.mock(IPokemonFactory.class);
    Pokemon charmander = new Pokemon(3,"Salamèche",203,185,229,219,282,2500,6,100);

    @BeforeEach
    public void setup()
    {
        when(mockIPokemonFactory.createPokemon(anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenAnswer(data -> {
            int pokemonIndex = data.getArgument(0);

            if(pokemonIndex < 0 || pokemonIndex > 150)
            {
                throw new PokedexException("Index du Pokemon incorrect");
            }

            return charmander;
        });
    }
    @Test
    public void shouldCreatePokemon()
    {
        assertEquals(charmander, mockIPokemonFactory.createPokemon(4,219,282,2500,6));
    }

    @Test
    public void shouldThrowWhenIndexTooLowOrHigh()
    {
        assertThrows(PokedexException.class, () -> mockIPokemonFactory.createPokemon(-1,219,282,2500,6));
        assertThrows(PokedexException.class, () -> mockIPokemonFactory.createPokemon(151,219,282,2500,6));
    }

}