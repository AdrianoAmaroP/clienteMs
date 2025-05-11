package br.com.ordermanger.cliente.exceptions;

public class ErroAoAcessarRepositorioException extends ErroDeSistema {


    public ErroAoAcessarRepositorioException() {
        super("produto.erroAcessarRepositorio", "Erro ao acessar repositorio de dados.", 500);
    }
}
