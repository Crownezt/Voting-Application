package com.martinso.votingapp.post.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PostResponse {
    private String message;
    private boolean isSuccess;
    private Long id;
    private int code;

}
