package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokemonMetadataProviderTest
{
    IPokemonMetadataProvider mockIPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
    Pokemon charmander = new Pokemon(3,"Salamèche",203,185,229,219,282,2500,6,100);

    @Test
    public void shouldGetPokemonMetadataCharmander() throws PokedexException
    {
        when(mockIPokemonMetadataProvider.getPokemonMetadata(3)).thenReturn(charmander);
        PokemonMetadata mockMetaData = mockIPokemonMetadataProvider.getPokemonMetadata(3);
        assertEquals(3, mockMetaData.getIndex());
        assertEquals("Salamèche", mockMetaData.getName());
        assertEquals(203, mockMetaData.getAttack());
        assertEquals(185, mockMetaData.getDefense());
        assertEquals(229, mockMetaData.getStamina());
    }
}