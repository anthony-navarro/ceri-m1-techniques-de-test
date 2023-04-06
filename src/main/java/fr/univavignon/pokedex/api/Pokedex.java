package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;
    private ArrayList<Pokemon> pokemonList = new ArrayList<>();

    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return this.pokemonList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
        return this.pokemonList .lastIndexOf(pokemon);
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if(id < 0 || id > (this.pokemonList.size() - 1))
        {
            throw new PokedexException("Index du Pokemon incorrect");
        }

        return this.pokemonList.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return this.pokemonList;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        ArrayList<Pokemon> compareList = new ArrayList<>(this.pokemonList);
        compareList.sort(order);
        return compareList;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return this.pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
