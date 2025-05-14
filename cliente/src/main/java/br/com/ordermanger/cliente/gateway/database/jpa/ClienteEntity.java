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
    private EnderecoEntity endereco;

    public ClienteEntity() {}

    public ClienteEntity(Long id, String nome, String cpf, LocalDate dataNascimento, EnderecoEntity endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}

