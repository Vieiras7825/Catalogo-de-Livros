// LivroRepository.java
package com.literalura.catalogo.repository;

import com.literalura.catalogo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloContaining(String titulo);
    List<Livro> findByIdioma(String idioma);

    @Query("SELECT l FROM Livro l ORDER BY l.numeroDownloads DESC")
    List<Livro> findTop10ByNumeroDownloads();
}
