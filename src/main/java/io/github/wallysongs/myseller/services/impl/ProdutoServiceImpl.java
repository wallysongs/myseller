package io.github.wallysongs.myseller.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.wallysongs.myseller.domain.Produto;
import io.github.wallysongs.myseller.repositories.ProdutoRepository;
import io.github.wallysongs.myseller.services.ProdutoService;
import io.github.wallysongs.myseller.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    
    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto buscarPeloId(Long id) {
        return this.produtoRepository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException("Objeto não encontrado!");
        });
    }

    public List<Produto> buscarTodos() {
        return this.produtoRepository.findAll();
    }
}
