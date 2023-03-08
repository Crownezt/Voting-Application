package com.martinso.votingapp.admin.data.model;

import com.martinso.votingapp.data.model.Address;
import com.martinso.votingapp.data.model.Gender;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String email;
    private String password;
    private String matchpassword;
    private String username;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
