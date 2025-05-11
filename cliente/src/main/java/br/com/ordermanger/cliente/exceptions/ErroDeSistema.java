package br.com.ordermanger.cliente.exceptions;

public class ErroDeSistema extends RuntimeException {
    private final String code;
    private final String message;
    private final Integer httpStatus;

    public ErroDeSistema(String code, String message, Integer httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
