package br.com.tcc.sceh.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageResponse handleIllegalArgumentException(final ApiException ex) {
        return new MessageResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), ex.getDetails());
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class MessageResponse {

        @JsonProperty
        private final Integer code;

        @JsonProperty
        private final String message;

        @JsonProperty
        private final List<String> details;

        public MessageResponse(final Integer code, final String message, final List<String> details) {
            super();
            this.code = code;
            this.message = message;
            this.details = details;
        }
    }
}

