package com.martinso.votingapp.userdetails.service;

import com.martinso.votingapp.data.model.Fullname;
import com.martinso.votingapp.exception.UserDetailsException;
import com.martinso.votingapp.userdetails.data.model.UserDetails;
import com.martinso.votingapp.userdetails.data.repository.UserDetailsRepository;
import com.martinso.votingapp.userdetails.dto.request.CreateUserDetailsRequest;
import com.martinso.votingapp.userdetails.dto.request.LoginRequest;
import com.martinso.votingapp.userdetails.dto.response.LoginResponse;
import com.martinso.votingapp.userdetails.dto.response.CreateUserDetailsResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository repository;

    @Autowired
    public UserDetailsServiceImpl(UserDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateUserDetailsResponse register(CreateUserDetailsRequest request) {
        String check = String.valueOf(repository.findUserByUsername(request.getUsername()));
            if(request.getUsername().equals(check))
                throw new UserDetailsException("User name already exists");
        String checkEmail = String.valueOf(repository.findUserByEmail(request.getEmail()));
            if (request.getEmail().equals(checkEmail))
                throw new UserDetailsException("There is an account with that email address already");
        UserDetails details = UserDetails.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .middleName(request.getMiddleName())
                .email(request.getEmail())
                .password(request.getPassword())
                .confirmPassword(request.getConfirmPassword())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .age(request.getAge())
                .username(request.getUsername())
                .NIN(request.getNIN())
                .VIN(request.getVIN())
                .gender(request.getGender())
                .createdAt(LocalDateTime.now())
                .build();

        UserDetails saved = repository.save(details);
        log.info("saved ->{}", saved);
        return getCreate(saved);
    }

    private boolean emailExists(String email) {
        return repository.findUserByEmail(email).isPresent();
    }

    @Override
    public LoginResponse userLogin(@NotNull LoginRequest request) {
        Optional<UserDetails> checkUser = repository.findUserByUsername(request.getUsername());
        if (checkUser.isEmpty()) {
            throw new UserDetailsException("Please register or input correct username");
        }
        UserDetails confirmUser = checkUser.get();
        confirmUser.setPassword(request.getPassword());
        UserDetails saved = repository.save(confirmUser);
        log.info("saved -> {}", saved);
        return getLoginResponse(saved);
    }

    @Override
    public UserDetails getUserById(Long userId) {
        return repository.findById(userId).orElseThrow(()->
            new UserDetailsException(String.format("User %s not found", userId))
        );
    }

//    @Override
//    public Optional<UserDetails> getUserByUsername(String username) {
//        return repository.findUserByUsername(username);
//    }

    private CreateUserDetailsResponse getCreate(UserDetails userDetail) {
        CreateUserDetailsResponse response = new CreateUserDetailsResponse();
        response.setId(userDetail.getId());
        response.setMessage("User registered successfully");
        response.setCode(HttpStatus.CREATED.value());
        response.setSuccess(true);
        response.setFullname(Fullname.builder()
                .firstName(userDetail.getFirstName())
                .lastName(userDetail.getLastName())
                .middleName(userDetail.getMiddleName())
                .build());
        return response;
    }
    private LoginResponse getLoginResponse(UserDetails userDetail){
        return LoginResponse.builder()
                .id(userDetail.getId())
                .code(HttpStatus.CREATED.value())
                .message("Welcome Back!")
                .isSuccess(true)
                .build();
    }



}
