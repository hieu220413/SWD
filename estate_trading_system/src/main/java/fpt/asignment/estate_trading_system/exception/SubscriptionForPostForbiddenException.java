package fpt.asignment.estate_trading_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SubscriptionForPostForbiddenException extends ResponseStatusException {
    public SubscriptionForPostForbiddenException(String message) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }
}