package com.martinso.votingapp.userdetails.dto.request;

import com.martinso.votingapp.config.PasswordMatches;
import com.martinso.votingapp.data.model.Address;
import com.martinso.votingapp.data.model.Gender;
import com.martinso.votingapp.util.regex.Validation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateUserDetailsRequest {


    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String username;
//    @Pattern(regexp = Validation.PASSWORD_PATTERN, message = "Invalid password")
    @PasswordMatches
    private String password;

    private String confirmPassword;
    @Pattern(regexp = Validation.EMAIL_PATTERN,message = "Invalid email address")
    private String email;
    private Address address;
    @Min(message = "Age is required", value = 18)
    private int age;
    private Gender gender;
    private String NIN;
    private String VIN;
}
