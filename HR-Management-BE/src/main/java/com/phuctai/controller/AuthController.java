package com.phuctai.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phuctai.common.JwtUtils;
import com.phuctai.dto.JwtResponse;
import com.phuctai.dto.LoginRequest;
import com.phuctai.dto.MessageResponse;
import com.phuctai.dto.SignupRequest;
import com.phuctai.entity.Role;
import com.phuctai.entity.User;
import com.phuctai.repository.RoleRepository;
import com.phuctai.repository.UserRepository;
import com.phuctai.service.UserDetailsImpl;
import com.phuctai.utils.ResponseUtils;
import static com.phuctai.config.Constants.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

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

    @Autowired
    ResponseUtils responseUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        JwtResponse result = new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);

        return responseUtils.getResponseEntity(result, 1, "Success", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signUpRequest) {


        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User();
        user.setUserId(signUpRequest.getUserId());
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findRoleByName(ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {

                    case "ADMIN":
                        Role adminRole = roleRepository.findRoleByName(ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role admin is not found"));
                        roles.add(adminRole);
                        break;

                    case "HR":
                        Role hrRole = roleRepository.findRoleByName(ROLE_HR)
                                .orElseThrow(() -> new RuntimeException("Error: Role HR is not found"));
                        roles.add(hrRole);

                        break;
                    default:
                        Role userRole = roleRepository.findRoleByName(ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
        return responseUtils.getResponseEntity(null, 1, "Success", HttpStatus.OK);
    }
}
