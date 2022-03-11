package br.com.freitas.dev.pokefreitas.control;

import br.com.freitas.dev.pokefreitas.model.Pokemon;
import br.com.freitas.dev.pokefreitas.service.CallPokeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    CallPokeApi callPokeApi;

    @GetMapping("/{pokeName}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable String pokeName){
        return ResponseEntity.ok(callPokeApi.getPokemon(pokeName));
    }
}
