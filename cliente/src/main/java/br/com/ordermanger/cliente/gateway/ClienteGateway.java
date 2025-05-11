package br.com.ordermanger.cliente.gateway;

import br.com.ordermanger.cliente.domain.Cliente;

public interface ClienteGateway {
    Long criar(Cliente cliente);
    boolean existePorId(Long id);
}

