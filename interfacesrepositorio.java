// LivroRepository.java
package com.literalura.catalogo.repository;

import com.literalura.catalogo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloContaining(String titulo);
    List<Livro> findByIdioma(String idioma);
}

// AutorRepository.java
package com.literalura.catalogo.repository;

import com.literalura.catalogo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNomeContaining(String nome);
    List<Autor> findByDataNascimentoBeforeAndDataFalecimentoAfter(LocalDate dataInicio, LocalDate dataFim);
}
