package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.payload.JwtAuthenticationResponse;
import com.example.demo.payload.LoginRequest;
import com.example.demo.payload.SignUpRequest;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication", description = "Authentication management APIs")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Operation(summary = "Sign in user", description = "Authenticates user and returns JWT token")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully authenticated"),
        @ApiResponse(responseCode = "401", description = "Invalid credentials")
    })
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @Operation(summary = "Sign up new user", description = "Registers a new user with the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User registered successfully"),
        @ApiResponse(responseCode = "400", description = "Username or email already exists")
    })
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is already taken!");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is already in use!");
        }

        // Create user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role.RoleName roleName = signUpRequest.getRole();

        if (roleName == null) {
            Role userRole = roleRepository.findByName(Role.RoleName.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(role);
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }
} 