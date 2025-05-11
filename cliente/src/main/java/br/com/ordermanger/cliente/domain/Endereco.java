package br.com.ordermanger.cliente.domain;

import br.com.ordermanger.cliente.controller.json.EnderecoJson;

public class Endereco {
    private String rua;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String cep, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public static Endereco mapJsonToEndereco(EnderecoJson json){
        return new Endereco(json.rua(), json.numero(), json.cep(), json.cidade(), json.estado());
    }
}

