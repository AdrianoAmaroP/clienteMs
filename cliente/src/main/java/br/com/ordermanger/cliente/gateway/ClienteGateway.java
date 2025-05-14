package br.com.ordermanger.cliente.gateway;

import br.com.ordermanger.cliente.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {
    Long criar(Cliente cliente);
    boolean existePorId(Long id);
    boolean existePorCpf(String cpf);
    Optional<Cliente> oberPorId(Long id);
    Optional<Cliente> obterPorCPF(String cpf);
    List<Cliente> obterTodosClientes();
    Cliente altera(Long id, Cliente cliente);
    void deletarPeloId(Long id);

}

