package br.com.ordermanger.cliente.controller.json;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record ClienteJson(
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String cpf,

        @NotNull
        @Past(message = "Data de nascimento deve estar no passado")
        LocalDate dataNascimento,

        @NotNull
        EnderecoJson enderecoJson
) {}

