package fpt.asignment.estate_trading_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BundleNotFoundException extends ResponseStatusException {
    public BundleNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
