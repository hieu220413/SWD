package fpt.asignment.estate_trading_system.controller;


import fpt.asignment.estate_trading_system.service.SubscriptionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Subscription")
@SecurityRequirement(name = "basicAuth")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;
}
