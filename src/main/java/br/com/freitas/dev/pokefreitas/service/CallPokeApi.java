package br.com.freitas.dev.pokefreitas.service;

import br.com.freitas.dev.pokefreitas.model.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class CallPokeApi {

    static String pokeApi = "https://pokeapi.co/api/v2/pokemon/";

    public Pokemon getPokemon(String pokemon) {
        String request = pokeApi + pokemon;

        try {
            URL url = new URL(request);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() != HttpStatus.OK.value()) {
                throw new RuntimeException("Error to request: " + connection.getResponseCode());
            } else {
                BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String pokeJson = Utilities.convertJsonEmString(response);
                Pokemon pokemonCreate = ConvertToPokemon.createBeast(pokeJson);
                return pokemonCreate;
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro de execução");
        }
    }

}
