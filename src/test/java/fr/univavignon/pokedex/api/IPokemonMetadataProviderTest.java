package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonMetadataProviderTest
{
    IPokemonMetadataProvider pokemonMetadataProvider = PokemonMetadataProvider.getPokemonMetadataProvider();
    PokemonMetadata charmanderData;
    Pokemon charmander;

    @BeforeEach
    public void setup() throws PokedexException {
        charmander = new Pokemon(2,"Salamèche",203,185,229,219,282,2500,6,100);
        charmanderData = pokemonMetadataProvider.getPokemonMetadata(2);
    }
    @Test
    public void shouldGetPokemonMetadataCharmander()
    {
        assertEquals(charmander.getIndex(), charmanderData.getIndex());
        assertEquals(charmander.getName(), charmanderData.getName());
        assertEquals(charmander.getAttack(), charmanderData.getAttack());
        assertEquals(charmander.getDefense(), charmanderData.getDefense());
        assertEquals(charmander.getStamina(), charmanderData.getStamina());
    }

    @Test
    public void shouldThrowWhenIndexTooLowOrHigh()
    {
        assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
        assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(151));
    }
}