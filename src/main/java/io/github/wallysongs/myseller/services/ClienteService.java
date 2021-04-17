package io.github.wallysongs.myseller.services;

import io.github.wallysongs.myseller.domain.Cliente;

public interface ClienteService {
    
    public Cliente buscarPeloId(Long id);
}
