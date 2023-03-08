package com.martinso.votingapp.election.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ElectionResponse {
    private String message;
    private boolean isSuccess;
    private Long id;
    private int code;
}
