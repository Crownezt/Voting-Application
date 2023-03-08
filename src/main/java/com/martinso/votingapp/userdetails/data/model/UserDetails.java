package com.martinso.votingapp.userdetails.data.model;

import com.martinso.votingapp.data.model.Address;
import com.martinso.votingapp.data.model.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;
    @NotBlank(message = "Middle name cannot be blank")
    private String middleName;
    private String phoneNumber;
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private int age;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String NIN;
    private String VIN;
    private LocalDateTime createdAt;
    @Transient
    private MultipartFile profileImage;
    private boolean enabled = true;

    @Override
    public String toString() {
        return "UserDetails{" + "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", age=" + age +
                ", gender=" + gender +
                ", NIN='" + NIN + '\'' +
                ", VIN='" + VIN + '\'' +
                ", createdAt=" + createdAt +
                ", profileImage=" + profileImage +
                ", enabled=" + enabled +
                '}';
    }


    //    private String achievement;

}
