package fpt.asignment.estate_trading_system.controller;


import fpt.asignment.estate_trading_system.model.UserCreateModel;
import fpt.asignment.estate_trading_system.model.UserModel;
import fpt.asignment.estate_trading_system.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Tag(name = "Subscription")
@SecurityRequirement(name = "basicAuth")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @Operation(summary = "Create subscription", description = "Create subscription", tags={ "Subscription" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create subscription successfully", content = @Content())})
    @RequestMapping(value = "/subscription/create",
            method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> createSubscription(@Parameter(in = ParameterIn.DEFAULT,  required = true) @RequestParam String postId,
                                                         @Parameter(in = ParameterIn.DEFAULT,  required = true) @RequestParam String bundleId,
                                                         @Parameter(in = ParameterIn.DEFAULT,  required = true) @RequestParam Long price,
                                                         @Parameter(hidden = true) @RequestHeader(HttpHeaders.AUTHORIZATION) String encodeAuthor
                                                         ) {
        System.out.println("asd");
        return subscriptionService.purchaseSubscription(postId, bundleId, encodeAuthor, price);
    }
}
