// EstatisticasService.java
package com.literalura.catalogo.service;

import com.literalura.catalogo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EstatisticasService {

    @Autowired
    private LivroRepository livroRepository;

    public Map<String, Long> obterEstatisticas() {
        Map<String, Long> estatisticas = new HashMap<>();
        estatisticas.put("totalLivros", livroRepository.count());
        estatisticas.put("totalAutores", livroRepository.countDistinctByAutor());
        return estatisticas;
    }
}
