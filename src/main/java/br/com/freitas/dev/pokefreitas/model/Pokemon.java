package br.com.freitas.dev.pokefreitas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
    private String name;
    private int id;
    private int weight;
    private String type;
}
