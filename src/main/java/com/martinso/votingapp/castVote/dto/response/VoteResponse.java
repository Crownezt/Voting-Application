package com.martinso.votingapp.castVote.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VoteResponse {
    private String message;
    private boolean isSuccess;
    private Long id;
    private int code;
}
