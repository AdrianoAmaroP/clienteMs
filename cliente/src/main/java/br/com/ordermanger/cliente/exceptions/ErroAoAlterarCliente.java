package br.com.ordermanger.cliente.exceptions;

public class ErroAoAlterarCliente extends ErroDeSistema{
    public static final String CODE = "cliente.erroAlterarCliente";
    public static final int HTTP_STATUS = 409;

    public ErroAoAlterarCliente(String mensagem) {
        super(CODE, mensagem, HTTP_STATUS);
    }
    public ErroAoAlterarCliente(Throwable cause) {
        super(cause, CODE, "Erro ao alterar cliente.", HTTP_STATUS);
    }
}
