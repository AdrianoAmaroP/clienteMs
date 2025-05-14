package br.com.ordermanger.cliente.gateway.database.jpa;

import br.com.ordermanger.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    boolean existsByCpf(String cpf);
    Optional<ClienteEntity> findByCpf(String cpf);
}
