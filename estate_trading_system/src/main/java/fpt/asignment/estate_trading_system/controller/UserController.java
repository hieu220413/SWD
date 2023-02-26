package fpt.asignment.estate_trading_system.controller;

import fpt.asignment.estate_trading_system.entity.Users;
import fpt.asignment.estate_trading_system.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "User")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Operation(summary = "Get user", description = "Get user", tags={ "User" })
    @RequestMapping(value = "/user/getUser",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Users> getUsersDetailTest() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findByUsername("admin"));
    }
}
