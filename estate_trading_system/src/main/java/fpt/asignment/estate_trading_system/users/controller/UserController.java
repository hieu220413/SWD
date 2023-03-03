package fpt.asignment.estate_trading_system.users.controller;

import fpt.asignment.estate_trading_system.common.exception.InvalidUserCreateInputException;
import fpt.asignment.estate_trading_system.common.model.UserCreateModel;
import fpt.asignment.estate_trading_system.common.model.UserModel;
import fpt.asignment.estate_trading_system.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Tag(name = "User")
@SecurityRequirement(name = "basicAuth")
public class UserController {
    @Autowired
    UserService userService;


    @ExceptionHandler(InvalidUserCreateInputException.class)
    public void handlerInvalidUserCreateInput(InvalidUserCreateInputException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getReason());
    }

    @Operation(summary = "Create user", description = "Create user", tags={ "User" })
    @RequestMapping(value = "/user/create",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<UserModel> createUser(@Parameter(in = ParameterIn.DEFAULT, description = "User sign up information", required = true, schema = @Schema()) @Valid @RequestBody UserCreateModel userDetail) {
        return userService.createUser(userDetail);
    }
}
