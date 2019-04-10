package com.andersen.maks.security;

import com.andersen.maks.model.User;
import com.andersen.maks.service.UserService;
import lombok.extern.slf4j.Slf4j;
import com.andersen.maks.security.jwt.JwtUser;
import com.andersen.maks.security.jwt.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;




@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private static final Logger log =  Logger.getLogger(JwtUserDetailsService.class);
    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded" + username.toString());
        return jwtUser;
    }
}
