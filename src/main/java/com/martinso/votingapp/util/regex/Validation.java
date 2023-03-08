package com.martinso.votingapp.util.regex;

import com.martinso.votingapp.userdetails.data.repository.UserDetailsRepository;
import com.martinso.votingapp.exception.AgeIsAllowedException;
import lombok.AllArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class Validation {
    private final UserDetailsRepository repository;
    
    public static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()-[{}]:;'?/*~$^+=<>]).{8,20}$";
    private static final Pattern pattern  = Pattern.compile(PASSWORD_PATTERN);
    public static boolean isValid(final String password){
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }



    public static final String EMAIL_PATTERN =
            "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isEmailValid(final String email){
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidAge(final int age){
        if(age <= 18){
            throw new AgeIsAllowedException("You must be 18 years old or older!");
        }
        return true;
    }

//    public String isValidUserName(final String userName){
//        if (!Objects.equals(userName, repository.findUserByUsername(userName))) {
//             throw new UserDetailsException("User " + userName + "not found in repository"
//        }
//    }
}
