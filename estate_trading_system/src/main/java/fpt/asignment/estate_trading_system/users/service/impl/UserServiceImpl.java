package fpt.asignment.estate_trading_system.users.service.impl;


import fpt.asignment.estate_trading_system.common.entity.Users;
import fpt.asignment.estate_trading_system.common.exception.InvalidUserCreateInputException;
import fpt.asignment.estate_trading_system.common.model.UserCreateModel;
import fpt.asignment.estate_trading_system.common.model.UserModel;
import fpt.asignment.estate_trading_system.common.repository.RoleRepository;
import fpt.asignment.estate_trading_system.common.repository.UserRepository;
import fpt.asignment.estate_trading_system.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    PasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public ResponseEntity<UserModel> createUser(UserCreateModel userDetail) {
        String errorMessage = "";
        Users userEntity = userRepository.findByUsername(userDetail.getUsername());
        if(userEntity != null){
            errorMessage += "Duplicate Username";
        }

//        if(this.isValidPassword(body.getPassword())){
//            errorMessage += "Password contains at least 8 characters, 1 digit, 1 lower alpha char and 1 upper alpha char";
//        }

        if(!errorMessage.isEmpty()){
            throw new InvalidUserCreateInputException(errorMessage);
        }

        if(userDetail.getAvatar() == null){
            userDetail.setAvatar("");
        }

        userEntity = Users.builder()
                .username(userDetail.getUsername())
                .password(bcryptPasswordEncoder.encode(userDetail.getPassword()))
                .role(roleRepository.findByName("USER"))
                .fullName(userDetail.getFullName())
                .age(userDetail.getAge())
                .gender(userDetail.getGender())
                .phone(userDetail.getPhone())
                .email(userDetail.getEmail())
                .avatar(userDetail.getAvatar())
                .status(Byte.parseByte("1"))
                .build();


        UserModel userModel = new UserModel(userRepository.save(userEntity));
        return ResponseEntity.status(HttpStatus.OK).body(userModel);
    }
}
