package br.com.ordermanger.cliente.exceptions;

public class ErroAoCriarCliente extends ErroDeSistema{
    public static final String CODE = "cliente.erroCriarCliente";
    public static final int HTTP_STATUS = 409;

    public ErroAoCriarCliente(String mensagem) {
        super(CODE, mensagem, HTTP_STATUS);
    }
    public ErroAoCriarCliente(Throwable ex) { super(ex, CODE, "Erro ao criar cliente.", HTTP_STATUS);}
}
