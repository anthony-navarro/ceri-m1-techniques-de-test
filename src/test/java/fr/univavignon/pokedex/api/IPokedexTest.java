package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class IPokedexTest {

    IPokemonFactory pokemonFactory = new PokemonFactory();
    List<Pokemon> pokemonList = new ArrayList<>();
    IPokemonMetadataProvider pokemonMetadataProvider = PokemonMetadataProvider.getPokemonMetadataProvider();
    IPokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
    Pokemon charmander = new Pokemon(2,"Salamèche",203,185,229,219,282,2500,6,100);
    Pokemon ninetales = new Pokemon(36,"Feunard",251,249,299,261,350,3000,3,56);

    @Test
    public void shouldGetSizePokemon()
    {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(charmander);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void shouldAddPokemon()
    {
        int pokemonIndex = pokedex.addPokemon(charmander);
        assertEquals(0, pokemonIndex);
    }

    @Test
    public void shouldGetPokemonThrowWhenWrongId() throws PokedexException
    {
        pokedex.addPokemon(charmander);

        assertThrows(PokedexException.class, () -> { pokedex.getPokemon(151); });
        assertThrows(PokedexException.class, () -> { pokedex.getPokemon(-1); });
    }

    @Test
    public void shouldGetPokemon() throws PokedexException
    {
        pokedex.addPokemon(charmander);

        Pokemon pokemon = pokedex.getPokemon(0);

        assertEquals(pokemon.getIndex(), charmander.getIndex());
    }
    @Test
    public void shouldGetPokemonsList()
    {
        pokedex.addPokemon(charmander);
        pokedex.addPokemon(ninetales);

        pokemonList = pokedex.getPokemons();

        assertEquals(pokemonList.get(0).getIndex(), charmander.getIndex());
    }

    @Test
    public void shouldComparatorGetPokemons()
    {
        pokedex.addPokemon(charmander);
        pokedex.addPokemon(ninetales);

        pokemonList = pokedex.getPokemons(PokemonComparators.INDEX);

        assertEquals(pokemonList.get(0).getIndex(), charmander.getIndex());
    }

    @Test
    public void shouldCreatePokemon() throws PokedexException {

       Pokemon charmanderPokedex =  pokedex.createPokemon(2,219,282,2500,6);

       assertEquals(charmanderPokedex.getIndex(), charmander.getIndex());
        assertEquals(charmanderPokedex.getCp(), charmander.getCp());
        assertEquals(charmanderPokedex.getHp(), charmander.getHp());
        assertEquals(charmanderPokedex.getDust(), charmander.getDust());
        assertEquals(charmanderPokedex.getCandy(), charmander.getCandy());
    }

    @Test
    public void shouldGetPokemonData() throws PokedexException {

        PokemonMetadata charmanderdata =  pokedex.getPokemonMetadata(2);

        assertEquals(charmander.getIndex(), charmanderdata.getIndex());
        assertEquals(charmander.getName(), charmanderdata.getName());
        assertEquals(charmander.getAttack(), charmanderdata.getAttack());
        assertEquals(charmander.getDefense(), charmanderdata.getDefense());
        assertEquals(charmander.getStamina(), charmanderdata.getStamina());
    }
}