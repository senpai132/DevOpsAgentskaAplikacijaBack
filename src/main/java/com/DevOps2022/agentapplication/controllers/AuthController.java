package com.DevOps2022.agentapplication.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.DevOps2022.agentapplication.helper.dto.UserDTO;
import com.DevOps2022.agentapplication.helper.dto.UserLoginDTO;
import com.DevOps2022.agentapplication.helper.dto.UserTokenStateDTO;
//import com.DevOps2022.agentapplication.helper.dto.UserProfileDTOs.UserProfileDTO;
import com.DevOps2022.agentapplication.helper.mappers.UserMapper;
import com.DevOps2022.agentapplication.model.User;
import com.DevOps2022.agentapplication.security.TokenUtils;
import com.DevOps2022.agentapplication.services.ClientService;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    /*@Autowired
    private UserDetailsServiceImpl userDetailsService;*/

    private UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userRequest,
                                     HttpServletRequest request) {
        try {
            clientService.registerUser(userMapper.toEntity(userRequest));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User successfully created.", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenStateDTO> createAuthenticationToken(@RequestBody UserLoginDTO authenticationRequest,
                                                                       HttpServletResponse response) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = (User) authentication.getPrincipal();
            String jwt = tokenUtils.generateToken(user);
            long expiresIn = tokenUtils.getExpiredIn();

            return ResponseEntity.ok(new UserTokenStateDTO(jwt, expiresIn));
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    
    public AuthController() {
        this.userMapper = new UserMapper();
    }
}
