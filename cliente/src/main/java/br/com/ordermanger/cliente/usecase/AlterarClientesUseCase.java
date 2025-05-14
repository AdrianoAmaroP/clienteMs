package br.com.ordermanger.cliente.usecase;

import br.com.ordermanger.cliente.domain.Cliente;
import br.com.ordermanger.cliente.exceptions.ErroAoAlterarCliente;
import br.com.ordermanger.cliente.exceptions.ErroAoCriarCliente;
import br.com.ordermanger.cliente.gateway.ClienteGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlterarClientesUseCase {
    private final ClienteGateway clienteGateway;

    public AlterarClientesUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente alterar(long id, Cliente cliente) {
        if (cliente.getId() != null && cliente.getId() != id) {
            throw new ErroAoAlterarCliente("id incompatível com informada no corpo da requisicao");
        }

        if() {
            throw new ErroAoCriarCliente("Já existe um outro cliente com este sku.");
        }

        return clienteGateway.altera(id, cliente);
    }

    public void deletar(long id) {
        clienteGateway.deleta(id);
    }
}
