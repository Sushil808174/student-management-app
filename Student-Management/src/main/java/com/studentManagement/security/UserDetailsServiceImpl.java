package com.studentManagement.security;

import com.studentManagement.entity.Admin;
import com.studentManagement.repository.AdminRepository;
import com.studentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Find the user by email (username)
        Optional<Admin> user = adminRepository.findByEmail(username);

        if (user.isPresent()) {
            Admin users = user.get();

            // Create a list of authorities (roles)
            List<GrantedAuthority> authorities = new ArrayList<>();

            // Add the user's role as a granted authority
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority(users.getRole());
            authorities.add(sga);

            // Create and return a UserDetails object representing the user
            // UserDetails contains user details required for authentication
            return new User(users.getEmail(), users.getPassword(), authorities);
        } else {
            // Throw an exception if the user is not found
            throw new BadCredentialsException("User Details not found with this username: " + username);
        }
    }
}
