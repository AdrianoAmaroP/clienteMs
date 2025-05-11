package br.com.ordermanger.cliente.gateway.database.jpa;

import br.com.ordermanger.cliente.domain.Endereco;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    private LocalDate dataNascimento;

    @Embedded
    private Endereco endereco;

    public ClienteEntity() {}

    public ClienteEntity(Long id, String nome, String cpf, LocalDate dataNascimento, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }
}

