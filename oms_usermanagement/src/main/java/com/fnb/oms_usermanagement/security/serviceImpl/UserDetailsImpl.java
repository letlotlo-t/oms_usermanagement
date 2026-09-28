package com.fnb.oms_usermanagement.security.serviceImpl;

import com.fnb.oms_usermanagement.entity.User;
import com.fnb.oms_usermanagement.entity.UserCredential;
import com.fnb.oms_usermanagement.repository.UserCredentialsRepository;
import com.fnb.oms_usermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserCredentialsRepository userCredentialsRepository;

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        UserCredential userCredential = userCredentialsRepository.findByUser_CustomerId(user.getCustomerId());


        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(userCredential.getPassword())
                .authorities(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
                .build();
    }
}