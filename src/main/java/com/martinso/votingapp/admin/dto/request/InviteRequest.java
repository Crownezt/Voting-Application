package com.martinso.votingapp.admin.dto.request;

import com.martinso.votingapp.data.model.Address;
import com.martinso.votingapp.data.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InviteRequest {
    private String firstName;
    private String lastName;
    private String middle;
    private String email;
    private String username;
    private String password;
    private String matchPassword;
    private Gender gender;
    private Address address;
}
