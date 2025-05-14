package br.com.ordermanger.cliente.gateway.database.jpa;

import br.com.ordermanger.cliente.domain.Cliente;
import br.com.ordermanger.cliente.domain.Endereco;
import br.com.ordermanger.cliente.exceptions.ErroAoAcessarRepositorioException;
import br.com.ordermanger.cliente.exceptions.ErroAoAlterarCliente;
import br.com.ordermanger.cliente.gateway.ClienteGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class ClienteJPAGateway implements ClienteGateway {

    Logger log = LoggerFactory.getLogger(ClienteJPAGateway.class);

    private final ClienteRepository clienteRepository;

    public ClienteJPAGateway(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Long criar(Cliente cliente) {
        try {
            // Mapeando o Cliente para ClienteEntity
            ClienteEntity clienteEntity = mapToEntity(cliente);

            return clienteRepository.save(clienteEntity).getId();
        } catch (Exception e) {
            log.error("Erro ao salvar o cliente: ", e);
            throw new ErroAoAcessarRepositorioException();
        }
    }

    @Override
    public boolean existePorId(Long id) {
        return clienteRepository.existsById(id);
    }

    @Override
    public boolean existePorCpf(String cpf) {
        return clienteRepository.existsByCpf(cpf);
    }

    @Override
    public Optional<Cliente> oberPorId(Long id) {
        return clienteRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public Optional<Cliente> obterPorCPF(String cpf) {
        return clienteRepository.findByCpf(cpf).map(this::mapToDomain);
    }

    @Override
    public List<Cliente> obterTodosClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public Cliente altera(Long id, Cliente cliente) {
        ClienteEntity clienteEmAlterecao = clienteRepository.getReferenceById(id);

        clienteEmAlterecao.setCpf(cliente.getCpf());
        clienteEmAlterecao.setEndereco(mapToEnderecoEntity(cliente.getEnderecos()));
        clienteEmAlterecao.setDataNascimento(cliente.getDataNascimento());
        clienteEmAlterecao.setNome(cliente.getNome());

        try {
            return mapToDomain(clienteRepository.save(clienteEmAlterecao));
        }catch (DataIntegrityViolationException e){
            throw new ErroAoAlterarCliente(e);
        }

    }

    @Override
    public void deletarPeloId(Long id) {
        clienteRepository.deleteById(id);
    }


    private Cliente mapToDomain(ClienteEntity cliente) {
        return new Cliente(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataNascimento(),
                mapToDomainEndereco(cliente.getEndereco())
        );
    }

    private Endereco mapToDomainEndereco(EnderecoEntity endereco) {
        return new Endereco(
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getEstado()
        );
    }

    private ClienteEntity mapToEntity(Cliente cliente) {
        return new ClienteEntity(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataNascimento(),
                mapToEnderecoEntity(cliente.getEnderecos())
        );
    }

    private EnderecoEntity mapToEnderecoEntity(Endereco endereco) {
        return new EnderecoEntity(
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getEstado()
        );
    }

}
