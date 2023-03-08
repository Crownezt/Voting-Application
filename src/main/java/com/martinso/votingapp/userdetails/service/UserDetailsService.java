package com.martinso.votingapp.userdetails.service;

import com.martinso.votingapp.userdetails.data.model.UserDetails;
import com.martinso.votingapp.userdetails.dto.request.CreateUserDetailsRequest;
import com.martinso.votingapp.userdetails.dto.request.LoginRequest;
import com.martinso.votingapp.userdetails.dto.response.CreateUserDetailsResponse;
import com.martinso.votingapp.userdetails.dto.response.LoginResponse;

public interface UserDetailsService {
    CreateUserDetailsResponse register(CreateUserDetailsRequest request);
    LoginResponse userLogin (LoginRequest request);
    UserDetails getUserById(Long userId);

//    Optional<UserDetails> getUserByUsername(String username);
}
