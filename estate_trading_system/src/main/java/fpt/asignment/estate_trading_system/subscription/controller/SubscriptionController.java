package fpt.asignment.estate_trading_system.subscription.controller;


import fpt.asignment.estate_trading_system.common.exception.*;
import fpt.asignment.estate_trading_system.exception.*;
import fpt.asignment.estate_trading_system.subscription.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@Tag(name = "Subscription")
@SecurityRequirement(name = "basicAuth")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;
    @ExceptionHandler(UserNotFoundException.class)
    public void handlerUserNotFound(UserNotFoundException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), e.getReason());
    }

    @ExceptionHandler(BundleNotFoundException.class)
    public void handlerBundleNotFound(BundleNotFoundException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), e.getReason());
    }

    @ExceptionHandler(PostNotFoundException.class)
    public void handlerPostNotFound(PostNotFoundException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), e.getReason());
    }

    @ExceptionHandler(SubscriptionForPostForbiddenException.class)
    public void handlerSubscriptionForPostForbidden(SubscriptionForPostForbiddenException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getReason());
    }

    @ExceptionHandler(PostAuthorInvalidException.class)
    public void handlerPostAuthorInvalid(PostAuthorInvalidException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value(), e.getReason());
    }

    @ExceptionHandler(OutOfRangePriceException.class)
    public void handlerOutOfRangePrice(OutOfRangePriceException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getReason());
    }

    @ExceptionHandler(OutofSlotBundleException.class)
    public void handlerOutofSlotBundle(OutofSlotBundleException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getReason());
    }
    @Operation(summary = "Create subscription", description = "Create subscription", tags={ "Subscription" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create subscription successfully", content = @Content())})
    @RequestMapping(value = "/subscription/create",
            method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> createSubscription(@Parameter(in = ParameterIn.DEFAULT,  required = true , example = "51d343a3-b84c-11ed-86dc-0a0027000019") @RequestParam String postId,
                                                         @Parameter(in = ParameterIn.DEFAULT,  required = true, example = "159ff66c-b84c-11ed-86dc-0a0027000019") @RequestParam String bundleId,
                                                         @Parameter(in = ParameterIn.DEFAULT,  required = true, example = "8444444") @RequestParam Long price,
                                                         @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String encodeAuthor
                                                         ) {
        System.out.println("asd");
        return subscriptionService.purchaseSubscription(postId, bundleId, encodeAuthor, price);
    }
}
