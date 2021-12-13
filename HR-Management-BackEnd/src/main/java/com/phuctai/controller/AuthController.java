package com.phuctai.controller;

import java.util.HashMap;
import java.util.Map;


import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phuctai.dao.UserDAO;
import com.phuctai.dto.LoginRequest;
import com.phuctai.dto.JwtResponse;
import com.phuctai.model.JwtUtils;
import com.phuctai.services.UserDetailsImpl;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class AuthController {

	private static final Logger LOGGER = Logger.getLogger(Authentication.class);
	
//	@Autowired
//	AuthenticationManager authenticationManager;
//	
//	@Autowired
//	UserDAO userDao;
//	
//	@Autowired
//	PasswordEncoder encoder;
//	
//	@Autowired
//	JwtUtils jwtUtils;
//	
//	@PostMapping("/signin")
//	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//		try {
//			Authentication authentication = authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//			
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//			String jwt = jwtUtils.generateJwtToken(authentication);
//			System.out.println(jwt);
//			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//			return getResponseEntity(
//					new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername()),"1","Login success!", HttpStatus.OK);
//		}catch (Exception e) {
//			return getResponseEntity(e, "-1", "Login fail!", HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	private ResponseEntity<?> getResponseEntity(Object data, String code, String mess, HttpStatus status) {
//		Map<String, Object> response = new HashMap<>();
//		response.put("data",data);
//		response.put("code",code);
//		response.put("messenger",mess);
//		return new ResponseEntity<>(response, status);
//	}
}
