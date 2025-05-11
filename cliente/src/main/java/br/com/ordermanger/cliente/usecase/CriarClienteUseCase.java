package br.com.ordermanger.cliente.usecase;

import br.com.ordermanger.cliente.domain.Cliente;
import br.com.ordermanger.cliente.gateway.ClienteGateway;
import org.springframework.stereotype.Service;

@Service
public class CriarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public CriarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Long criar(Cliente cliente) {
        return clienteGateway.criar(cliente);
    }
}
