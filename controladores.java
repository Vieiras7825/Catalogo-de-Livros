// LivroController.java
package com.literalura.catalogo.controller;

import com.literalura.catalogo.model.Livro;
import com.literalura.catalogo.service.GutendexService;
import com.literalura.catalogo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private GutendexService gutendexService;

    @GetMapping
    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    @PostMapping("/buscar")
    public Livro buscarLivroPorTitulo(@RequestParam String titulo) throws IOException {
        Livro livro = gutendexService.buscarLivroPorTitulo(titulo);
        return livroService.salvar(livro);
    }

    @GetMapping("/titulo")
    public List<Livro> buscarPorTitulo(@RequestParam String titulo) {
        return livroService.buscarPorTitulo(titulo);
    }

    @GetMapping("/idioma")
    public List<Livro> buscarPorIdioma(@RequestParam String idioma) {
        return livroService.buscarPorIdioma(idioma);
    }
}

// AutorController.java
package com.literalura.catalogo.controller;

import com.literalura.catalogo.model.Autor;
import com.literalura.catalogo.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> listarTodos() {
        return autorService.listarTodos();
    }

    @GetMapping("/nome")
    public List<Autor> buscarPorNome(@RequestParam String nome) {
        return autorService.buscarPorNome(nome);
    }

    @GetMapping("/ano")
    public List<Autor> buscarPorAno(@RequestParam int ano) {
        return autorService.buscarPorAno(ano);
    }
}
