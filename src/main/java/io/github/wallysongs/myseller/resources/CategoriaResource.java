package io.github.wallysongs.myseller.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wallysongs.myseller.entities.Categoria;
import io.github.wallysongs.myseller.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    private CategoriaService categoriaService;

    public CategoriaResource(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        List<Categoria> categorias = categoriaService.buscarTodos();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
        Categoria categoria = categoriaService.buscarPeloId(id);
        return ResponseEntity.ok(categoria);
    }
}
