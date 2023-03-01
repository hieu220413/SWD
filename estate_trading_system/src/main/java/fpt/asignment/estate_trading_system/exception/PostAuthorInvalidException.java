package fpt.asignment.estate_trading_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PostAuthorInvalidException extends ResponseStatusException {
    public PostAuthorInvalidException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}