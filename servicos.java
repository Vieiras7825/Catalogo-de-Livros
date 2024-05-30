// LivroService.java
package com.literalura.catalogo.service;

import com.literalura.catalogo.model.Livro;
import com.literalura.catalogo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContaining(titulo);
    }

    public List<Livro> buscarPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }
}

// AutorService.java
package com.literalura.catalogo.service;

import com.literalura.catalogo.model.Autor;
import com.literalura.catalogo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> buscarPorNome(String nome) {
        return autorRepository.findByNomeContaining(nome);
    }

    public List<Autor> buscarPorAno(int ano) {
        LocalDate dataInicio = LocalDate.of(ano, 1, 1);
        LocalDate dataFim = LocalDate.of(ano, 12, 31);
        return autorRepository.findByDataNascimentoBeforeAndDataFalecimentoAfter(dataInicio, dataFim);
    }
}
