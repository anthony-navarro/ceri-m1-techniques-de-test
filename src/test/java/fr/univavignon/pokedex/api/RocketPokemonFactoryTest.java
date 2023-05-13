package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RocketPokemonFactoryTest {

    IPokemonFactory rocketPokemonFactory = new RocketPokemonFactory();
    Pokemon charmander;
    Pokemon charmanderFactory;

    @BeforeEach
    public void setup() throws PokedexException {
        charmander = new Pokemon(2,"Salamèche",203,185,229,219,282,2500,6,100);
        charmanderFactory = rocketPokemonFactory.createPokemon(2, 219,282,2500,6);
    }
    @Test
    public void shouldCreatePokemon()
    {
        assertEquals(charmander.getIndex(), charmanderFactory.getIndex());
        assertNotEquals(charmander.getName(), charmanderFactory.getName());
        assertEquals(charmander.getCp(), charmanderFactory.getCp());
        assertEquals(charmander.getHp(), charmanderFactory.getHp());
        assertEquals(charmander.getDust(), charmanderFactory.getDust());
        assertEquals(charmander.getCandy(), charmanderFactory.getCandy());

        assertNotEquals(charmander.getAttack(), charmanderFactory.getAttack());
        assertNotEquals(charmander.getDefense(), charmanderFactory.getDefense());
        assertNotEquals(charmander.getStamina(), charmanderFactory.getStamina());
        assertNotEquals(charmander.getIv(), charmanderFactory.getIv());
    }

    @Test
    public void shouldThrowWhenIndexTooLowOrHigh()
    {
        assertDoesNotThrow(() -> rocketPokemonFactory.createPokemon(-1,219,282,2500,6));
        assertDoesNotThrow(() -> rocketPokemonFactory.createPokemon(151,219,282,2500,6));
    }
}
