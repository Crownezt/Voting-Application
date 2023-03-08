package com.martinso.votingapp.config;

import jakarta.validation.Payload;

public @interface PasswordMatches {
    String message() default "Password don't match";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
