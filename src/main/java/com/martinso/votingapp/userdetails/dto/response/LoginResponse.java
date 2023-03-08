package com.martinso.votingapp.userdetails.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LoginResponse {
    private String message;
    private boolean isSuccess;
    private Long id;
    private int code;
}
