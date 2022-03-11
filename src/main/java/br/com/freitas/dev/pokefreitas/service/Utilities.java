package br.com.freitas.dev.pokefreitas.service;

import java.io.BufferedReader;
import java.io.IOException;

public class Utilities {
    public static String convertJsonEmString(BufferedReader bufferedReader) throws IOException {
        String response, json="";
        while((response=bufferedReader.readLine())!=null){
            json+=response;
        }
        return json;
    }
}
