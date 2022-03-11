package br.com.freitas.dev.pokefreitas.service;

import br.com.freitas.dev.pokefreitas.model.Pokemon;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConvertToPokemon {
    public static Pokemon createBeast(String json){
        String name = JsonParser.parseString(json).getAsJsonObject().get("name").getAsString();
        int id = JsonParser.parseString(json).getAsJsonObject().get("id").getAsInt();
        int weight = JsonParser.parseString(json).getAsJsonObject().get("weight").getAsInt();
        String type = JsonParser.parseString(json).getAsJsonObject().get("types")
                .getAsJsonArray().get(0)
                .getAsJsonObject().get("type")
                .getAsJsonObject().get("name")
                .getAsString();
        Pokemon pokemon = new Pokemon(name, id, weight,type);
        return pokemon;
    }
}
