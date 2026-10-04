package com.derradjiamine.Backend.services;

import com.derradjiamine.Backend.entities.UserAccount;
import com.derradjiamine.Backend.shared.CustomResponseException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserAccount> account = userAccountRepo.findOneByUsername(username);

        if (account.isEmpty()) {
            throw CustomResponseException.BadCredentials();
        }

        UserAccount user = account.get();
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}
