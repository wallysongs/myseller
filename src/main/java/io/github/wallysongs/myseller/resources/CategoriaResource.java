package io.github.wallysongs.myseller.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
    
    @GetMapping
    public String findAll() {
        return "<h1>Categorias</h1>";
    }
}
