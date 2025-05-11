package br.com.ordermanger.cliente.controller;


import br.com.ordermanger.cliente.controller.json.ClienteJson;
import br.com.ordermanger.cliente.domain.Cliente;
import br.com.ordermanger.cliente.domain.Endereco;
import br.com.ordermanger.cliente.usecase.CriarClienteUseCase;
import br.com.ordermanger.cliente.usecase.ValidarClienteUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

    private final CriarClienteUseCase criarClienteUseCase;
    private final ValidarClienteUseCase validarClienteUseCase;

    public ClienteController(CriarClienteUseCase criarClienteUseCase, ValidarClienteUseCase validarClienteUseCase) {
        this.criarClienteUseCase = criarClienteUseCase;
        this.validarClienteUseCase = validarClienteUseCase;
    }

    @PostMapping
    public Long criar(@Valid @RequestBody ClienteJson clienteJson) {
        return criarClienteUseCase.criar(toDomain(clienteJson));
    }

    @GetMapping("{id}/validar")
    public boolean validar(@PathVariable Long id) {
        return validarClienteUseCase.clienteExiste(id);
    }

    private Cliente toDomain(ClienteJson clienteJson) {
        return new Cliente(
                clienteJson.id(),
                clienteJson.nome(),
                clienteJson.cpf(),
                clienteJson.dataNascimento(),
                Endereco.mapJsonToEndereco(clienteJson.enderecoJson())
        );
    }
}
