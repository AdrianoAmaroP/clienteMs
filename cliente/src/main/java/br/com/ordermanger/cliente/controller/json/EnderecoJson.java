package br.com.ordermanger.cliente.controller.json;

import jakarta.validation.constraints.NotBlank;

public record EnderecoJson(

        @NotBlank
        String rua,

        @NotBlank
        String numero,

        @NotBlank
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String estado

) {}