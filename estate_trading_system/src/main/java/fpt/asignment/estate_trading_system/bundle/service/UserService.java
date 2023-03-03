package fpt.asignment.estate_trading_system.bundle.service;

import fpt.asignment.estate_trading_system.common.model.UserCreateModel;
import fpt.asignment.estate_trading_system.common.model.UserModel;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<UserModel> createUser(UserCreateModel userDetail);
}
