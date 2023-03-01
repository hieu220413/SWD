package fpt.asignment.estate_trading_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OutOfRangePriceException extends ResponseStatusException {
    public OutOfRangePriceException(String message) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }
}
