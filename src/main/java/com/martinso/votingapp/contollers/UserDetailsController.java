package com.martinso.votingapp.contollers;

import com.martinso.votingapp.userdetails.dto.request.CreateUserDetailsRequest;
import com.martinso.votingapp.userdetails.dto.response.CreateUserDetailsResponse;
import com.martinso.votingapp.userdetails.dto.request.LoginRequest;
import com.martinso.votingapp.userdetails.dto.response.LoginResponse;
import com.martinso.votingapp.userdetails.service.UserDetailsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserDetailsController {

    private final UserDetailsService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid CreateUserDetailsRequest request){
        CreateUserDetailsResponse response = service.register(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/login")
    public ResponseEntity< ? > UserLogin(@RequestBody LoginRequest request) {
        LoginResponse response = service.userLogin(request);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("{userId}")
    public ResponseEntity<?> getUserByUsername(@PathVariable Long userId) {
        var foundPassenger = service.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(foundPassenger);
    }




}
