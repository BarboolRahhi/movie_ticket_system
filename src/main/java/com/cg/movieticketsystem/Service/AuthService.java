package com.cg.movieticketsystem.Service;

import com.cg.movieticketsystem.dto.request.LoginRequest;
import com.cg.movieticketsystem.dto.request.SignupRequest;
import com.cg.movieticketsystem.dto.response.JwtResponse;
import com.cg.movieticketsystem.dto.response.MessageResponse;
import com.cg.movieticketsystem.entity.Role;
import com.cg.movieticketsystem.entity.RoleType;
import com.cg.movieticketsystem.entity.User;
import com.cg.movieticketsystem.exception.AlreadyExistsException;
import com.cg.movieticketsystem.repository.RoleRepository;
import com.cg.movieticketsystem.repository.UserRepository;
import com.cg.movieticketsystem.security.JwtUtils;
import com.cg.movieticketsystem.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static com.cg.movieticketsystem.util.Constants.ALREADY_EXISTS;
import static com.cg.movieticketsystem.util.Constants.REGISTERED_SUCCESSFULLY;

@Service
@Transactional
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    public JwtResponse authenticateUser(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new JwtResponse(
                userDetails.getUsername(),
                token
        );
    }

    public MessageResponse registerUser(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AlreadyExistsException(ALREADY_EXISTS);
        }
        User newUser = new User(
                request.getUsername(),
                request.getEmail(),
                encoder.encode(request.getPassword()),
                request.getContact()
        );

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName(RoleType.ROLE_CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(role);
        newUser.setRoles(roles);
        userRepository.save(newUser);
        return new MessageResponse(REGISTERED_SUCCESSFULLY);
    }

}
