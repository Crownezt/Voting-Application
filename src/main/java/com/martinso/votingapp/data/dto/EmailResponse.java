package com.martinso.votingapp.data.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EmailResponse {
    private int code;
    private String message;
    private boolean isSuccess;
}
