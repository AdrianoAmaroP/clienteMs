package br.com.ordermanger.cliente.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.time.LocalDate;
import java.util.List;

public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Endereco endereco;

    public Cliente(Long id, String nome, String cpf, LocalDate dataNascimento, Endereco endereco) {
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

    public Endereco getEnderecos() {
        return endereco;
    }
}
