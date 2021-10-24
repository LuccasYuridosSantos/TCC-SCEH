package br.com.tcc.sceh.exceptions;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class SechException extends RuntimeException{

    private final int errorCode;
    private final HttpStatus statusCode;
    private final List<String> details = new ArrayList<>();

    protected SechException(final String message, final int errorCode) {
        this(message, errorCode, HttpStatus.BAD_REQUEST);
    }

    protected SechException(final String message, final int errorCode, final HttpStatus statusCode) {
        super(message);
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

    protected SechException(final Throwable cause, final int errorCode, final HttpStatus statusCode) {
        super(cause);
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

    public SechException(final String message, final int errorCode, final HttpStatus statusCode, final List<String> details) {
        super(message);
        this.errorCode = errorCode;
        this.statusCode = statusCode;
        this.details.addAll(details);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public List<String> getDetails() {
        return details;
    }
}
