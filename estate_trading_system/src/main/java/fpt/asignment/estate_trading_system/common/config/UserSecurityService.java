package fpt.asignment.estate_trading_system.common.config;

import fpt.asignment.estate_trading_system.common.entity.Users;
import fpt.asignment.estate_trading_system.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userEntity = userRepository.findByUsername(username);
        UserDetailsPrincipalModel user = UserDetailsPrincipalModel.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .role(userEntity.getRole().getName())
                .build();
        UserDetailsPrincipal userDetailsPrincipal = new UserDetailsPrincipal(user);
        return userDetailsPrincipal;
    }
}
