package br.com.ordermanger.cliente.usecase;

import br.com.ordermanger.cliente.gateway.ClienteGateway;
import org.springframework.stereotype.Service;

@Service
public class ValidarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public ValidarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public boolean clienteExistePeloId(Long id) {
        return clienteGateway.existePorId(id);
    }

    public boolean clienteExistePeloCpf(String cpf) {return clienteGateway.existePorCpf(cpf); }
}
