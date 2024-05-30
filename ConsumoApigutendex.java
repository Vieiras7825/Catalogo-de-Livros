// GutendexService.java
package com.literalura.catalogo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.literalura.catalogo.model.Livro;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class GutendexService {

    private static final String API_URL = "https://gutendex.com/books";

    public Livro buscarLivroPorTitulo(String titulo) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "?search=" + titulo;
        String response = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response);
        JsonNode book = root.path("results").get(0);

        Livro livro = new Livro();
        livro.setTitulo(book.path("title").asText());
        livro.setAutor(book.path("authors").get(0).path("name").asText());
        livro.setIdioma(book.path("languages").get(0).asText());
        livro.setNumeroDownloads(book.path("download_count").asInt());

        return livro;
    }
}
