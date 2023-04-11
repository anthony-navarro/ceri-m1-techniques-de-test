package fr.univavignon.pokedex.api;

import java.util.ArrayList;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private static PokemonMetadataProvider pokemonMetadataProvider;
    private ArrayList<PokemonMetadata> pokemonList = new ArrayList<>();

    private PokemonMetadataProvider() {}

    public static synchronized PokemonMetadataProvider getPokemonMetadataProvider() {
        if (pokemonMetadataProvider == null)
        {
            pokemonMetadataProvider = new PokemonMetadataProvider();
            pokemonMetadataProvider.generateList();
        }

        return pokemonMetadataProvider;
    }
    private void generateList() {
        PokemonMetadata charmander = new PokemonMetadata(2,"Salamèche",203,185,229);
        PokemonMetadata ninetales = new PokemonMetadata(36,"Feunard",251,249,299);

        for (int i = 0; i < 151; i++)
        {
            if (i == 2)
            {
                this.pokemonList.add(charmander);
                continue;
            }

            if (i == 133)
            {
                this.pokemonList.add(ninetales);
                continue;
            }

            this.pokemonList.add(new PokemonMetadata(i, "???", 0, 0, 0));
        }
    }


    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index < 0 || index > (this.pokemonList.size() - 1))
        {
            throw new PokedexException("Index du Pokemon incorrect");
        }

        return this.pokemonList.get(index);
    }
}
