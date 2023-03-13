package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokedexFactoryTest
{
    IPokedexFactory mockIPokedexFactoryFirst = Mockito.mock(IPokedexFactory.class);
    IPokemonFactory mockIPokemonFactorySecond = Mockito.mock(IPokemonFactory.class);
    IPokedex mockIPokedex = Mockito.mock(IPokedex.class);
    IPokemonMetadataProvider mockIPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

    @Test
    public void shouldCreatePokedex()
    {
        when(mockIPokedexFactoryFirst.createPokedex(mockIPokemonMetadataProvider, mockIPokemonFactorySecond)).thenReturn(mockIPokedex);
        assertEquals(mockIPokedex, mockIPokedexFactoryFirst.createPokedex(mockIPokemonMetadataProvider, mockIPokemonFactorySecond));
    }
}