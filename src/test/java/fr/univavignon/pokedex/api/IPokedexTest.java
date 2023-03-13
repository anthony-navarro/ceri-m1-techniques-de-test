package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokedexTest {

    List<Pokemon> pokemonList;
    IPokedex mockIPokedex = mock(IPokedex.class);
    Pokemon charmander = new Pokemon(3,"Salamèche",203,185,229,219,282,2500,6,100);
    Pokemon ninetales = new Pokemon(37,"Feunard",251,249,299,261,350,3000,3,56);

    @BeforeEach
    public void setup() throws PokedexException {
        pokemonList = new ArrayList<Pokemon>();

        when(mockIPokedex.addPokemon(any(Pokemon.class))).thenAnswer(data ->
        {
                pokemonList.add(data.getArgument(0));
                return pokemonList.size() - 1;
        });

        when(mockIPokedex.size()).thenAnswer(data -> pokemonList.size());

        when(mockIPokedex.getPokemon(any(Integer.class))).thenAnswer( data -> {
                int pokemonIndex = data.getArgument(0);

                if(pokemonIndex < 0 || pokemonIndex > 150)
                {
                    throw new PokedexException("Index du Pokemon incorrect");
                }

                return pokemonList.get(pokemonIndex);
        });

        when(mockIPokedex.getPokemons()).thenAnswer( data -> pokemonList);

        when(mockIPokedex.getPokemons(any())).thenAnswer(data -> {
            Comparator<Pokemon> pokemonComparator = (pokemon1, pokemon2) -> {

                if (pokemon1.getIndex() < pokemon2.getIndex())
                {
                    return -1;
                }
                else if (pokemon1.getIndex() == pokemon2.getIndex())
                {
                    return 0;
                }

                return 0;
            };

            pokemonList.sort(pokemonComparator);
            return pokemonList;
        });
    }
    @Test
    public void shouldGetSizePokemon()
    {
        assertEquals(0, mockIPokedex.size());
        mockIPokedex.addPokemon(charmander);
        assertEquals(1, mockIPokedex.size());
    }

    @Test
    public void shouldAddPokemon()
    {
        int pokemonIndex = mockIPokedex.addPokemon(charmander);
        assertEquals(0, pokemonIndex);
    }

    @Test
    public void shouldGetPokemonThrowWhenWrongId() throws PokedexException
    {
        mockIPokedex.addPokemon(charmander);

        when(mockIPokedex.getPokemon(anyInt())).thenAnswer(data -> {

            int pokemonIndex = data.getArgument(0);

            if(pokemonIndex < 0 || pokemonIndex > 150)
            {
                throw new PokedexException("Index du Pokemon incorrect");
            }

            return charmander;
        });

        assertThrows(PokedexException.class, () -> { mockIPokedex.getPokemon(265); });
    }

    @Test
    public void shouldGetPokemon() throws PokedexException
    {
        mockIPokedex.addPokemon(charmander);

        Pokemon pokemon = mockIPokedex.getPokemon(0);

        assertEquals(pokemon.getIndex(), charmander.getIndex());
    }
    @Test
    public void shouldGetPokemonsList()
    {
        mockIPokedex.addPokemon(charmander);
        mockIPokedex.addPokemon(ninetales);

        pokemonList = mockIPokedex.getPokemons();

        assertEquals(pokemonList.get(0).getIndex(), charmander.getIndex());
    }

    @Test
    public void shouldComparatorGetPokemons() {
        Comparator<Pokemon> pokemonComparator = (pokemon1, pokemon2) -> {

            if (pokemon1.getIndex() < pokemon2.getIndex())
            {
                return -1;
            }
            else if (pokemon1.getIndex() == pokemon2.getIndex())
            {
                return 0;
            }

            return 0;
        };

        mockIPokedex.addPokemon(charmander);
        mockIPokedex.addPokemon(ninetales);

        pokemonList = mockIPokedex.getPokemons(pokemonComparator);

        assertEquals(pokemonList.get(0).getIndex(), charmander.getIndex());
    }
}