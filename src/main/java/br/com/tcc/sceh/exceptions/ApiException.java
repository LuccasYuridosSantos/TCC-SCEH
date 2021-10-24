package br.com.tcc.sceh.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ApiException extends SechException{

    protected ApiException(final String message, final int errorCode, final HttpStatus statusCode, final List<String> details) {
        super(message, errorCode, statusCode, details);
    }

    public static ApiException invalidRequest(final List<String> details) {
        return new ApiException("Malformed Request", BAD_REQUEST.value(), BAD_REQUEST, details);
    }
}
