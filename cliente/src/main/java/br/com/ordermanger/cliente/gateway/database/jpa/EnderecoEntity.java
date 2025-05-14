package br.com.ordermanger.cliente.gateway.database.jpa;

import jakarta.persistence.Embeddable;

@Embeddable
public class EnderecoEntity {
    private String rua;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;

    public EnderecoEntity() {
    }

    public EnderecoEntity(String rua, String numero, String cep, String cidade, String estado) {
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
}
