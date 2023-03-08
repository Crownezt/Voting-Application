package com.martinso.votingapp.office.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class OfficeResponse {
    private String message;
    private boolean isSuccess;
    private Long id;
    private int code;
}
