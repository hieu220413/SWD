package fpt.asignment.estate_trading_system.service;

import fpt.asignment.estate_trading_system.entity.Users;
import fpt.asignment.estate_trading_system.model.UserCreateModel;
import fpt.asignment.estate_trading_system.model.UserModel;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<UserModel> createUser(UserCreateModel userDetail);
}
