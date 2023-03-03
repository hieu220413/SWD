package fpt.asignment.estate_trading_system.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidUserCreateInputException extends ResponseStatusException {
    public InvalidUserCreateInputException(String message) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }
}
