package br.com.ordermanger.cliente.usecase;

import br.com.ordermanger.cliente.domain.Cliente;
import br.com.ordermanger.cliente.gateway.ClienteGateway;
import org.springframework.stereotype.Service;

import javax.swing.event.CaretListener;
import java.util.List;
import java.util.Optional;

@Service
public class ObterClienteUseCase {
    private final ClienteGateway clienteGateway;

    public ObterClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public List<Cliente> obterTodos(){return clienteGateway.obterTodosClientes();}
    public Optional<Cliente> obterClientePeloCpf(String cpf){return clienteGateway.obterPorCPF(cpf);}
    public Optional<Cliente> obterClientePeloId(Long id){return clienteGateway.oberPorId(id);}
}
