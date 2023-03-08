package com.martinso.votingapp.candidate.data.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CandidateResponse {
    private String message;
    private boolean isSuccess;
    private Long id;
    private int code;
}
