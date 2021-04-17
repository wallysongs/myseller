package io.github.wallysongs.myseller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.wallysongs.myseller.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
    
}
