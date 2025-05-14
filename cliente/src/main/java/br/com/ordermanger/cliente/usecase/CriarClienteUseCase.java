package br.com.ordermanger.cliente.usecase;

import br.com.ordermanger.cliente.domain.Cliente;
import br.com.ordermanger.cliente.exceptions.ErroAoCriarCliente;
import br.com.ordermanger.cliente.gateway.ClienteGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public CriarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Long criar(Cliente cliente) {

        if(clienteGateway.existePorCpf(cliente.getCpf())) {
            throw new ErroAoCriarCliente("Já existe um cliente com este CPF.");
        }

        return clienteGateway.criar(cliente);
    }
}
