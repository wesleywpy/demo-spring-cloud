package com.wesley.auth.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/12/17
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户模块业务数据

        return User.withUsername(username)
                   .password(passwordEncoder.encode("123456"))
                   .authorities("ROLE_ADMIN")
                   .build();
    }

}
