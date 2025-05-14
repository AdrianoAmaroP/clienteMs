package br.com.ordermanger.cliente.exceptions;

import org.springframework.http.HttpStatus;

public class ErroDeSistema extends RuntimeException {
    private final String code;
    private final HttpStatus httpStatus;

    public ErroDeSistema(String code, String message, Integer httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = HttpStatus.resolve(httpStatus);
    }

    public ErroDeSistema(Throwable cause, String code, String message, Integer httpStatus) {
        super(message, cause);
        this.code = code;
        this.httpStatus = HttpStatus.resolve(httpStatus);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
