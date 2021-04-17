package io.github.wallysongs.myseller.services.impl;

import org.springframework.stereotype.Service;

import io.github.wallysongs.myseller.domain.Cliente;
import io.github.wallysongs.myseller.repositories.ClienteRepository;
import io.github.wallysongs.myseller.services.ClienteService;
import io.github.wallysongs.myseller.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarPeloId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException("Cliente não encontrado!");
        });
    }
}
