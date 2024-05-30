// LivroRepository.java
package com.literalura.catalogo.repository;

import com.literalura.catalogo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloContaining(String titulo);
    List<Livro> findByIdioma(String idioma);

    @Query("SELECT COUNT(DISTINCT l.autor) FROM Livro l")
    Long countDistinctByAutor();
}
