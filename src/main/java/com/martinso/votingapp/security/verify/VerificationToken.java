package com.martinso.votingapp.security.verify;

import com.martinso.votingapp.userdetails.data.model.UserDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VerificationToken {
    private static final int EXPIRATION = 60 * 6;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;

    @OneToOne(targetEntity = UserDetails.class, fetch =  FetchType.EAGER)
    @JoinColumn(nullable = false, name = "User_id")
    private UserDetails user;
    private Date expriryDate;
    private Date calculateExpiryDate(int expiryTimeMinutes){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeMinutes);
        return new Date(cal.getTime().getTime());
    }
}
