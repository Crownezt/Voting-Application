package com.martinso.votingapp.admin.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AdminDto {
    private String message;
    private boolean isSuccess;
    private int code;
    private Long id;
}
