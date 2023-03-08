package com.martinso.votingapp.userdetails.dto.response;

import com.martinso.votingapp.data.model.Fullname;
import lombok.*;
import org.hibernate.annotations.Formula;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateUserDetailsResponse {
    private String message;
    private boolean isSuccess;
    private Long id;
    private int code;
    private Fullname fullname;

}
