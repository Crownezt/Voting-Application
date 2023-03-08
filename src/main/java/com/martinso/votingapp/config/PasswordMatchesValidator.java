package com.martinso.votingapp.config;

import com.martinso.votingapp.userdetails.dto.request.CreateUserDetailsRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        CreateUserDetailsRequest request = (CreateUserDetailsRequest) o;
        return request.getPassword().equals(request.getConfirmPassword());
    }
}
