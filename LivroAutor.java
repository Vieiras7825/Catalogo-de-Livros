// Livro.java
package com.literalura.catalogo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String idioma;
    private int numeroDownloads;

    // getters e setters
}

// Autor.java
package com.literalura.catalogo.model;

import javax.persistence.*;
        import java.time.LocalDate;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private LocalDate dataFalecimento;

    // getters e setters
}
