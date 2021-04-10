package io.github.wallysongs.myseller.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wallysongs.myseller.entity.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
    
    @GetMapping
    public List<Categoria> findAll() {
        Categoria cat1 = new Categoria(1L, "Informática");
        Categoria cat2 = new Categoria(2L, "Escritório");
        return Arrays.asList(cat1, cat2);
    }
}
