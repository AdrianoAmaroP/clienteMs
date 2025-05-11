package br.com.ordermanger.cliente.gateway.database.jpa;

import br.com.ordermanger.cliente.domain.Cliente;
import br.com.ordermanger.cliente.domain.Endereco;
import br.com.ordermanger.cliente.exceptions.ErroAoAcessarRepositorioException;
import br.com.ordermanger.cliente.gateway.ClienteGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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

    private ClienteEntity mapToEntity(Cliente cliente) {
        return new ClienteEntity(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataNascimento(),
                mapToEnderecoEntity(cliente.getEnderecos())
        );
    }

    private Endereco mapToEnderecoEntity(Endereco endereco) {
        return new Endereco(
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getEstado()
        );
    }
}
