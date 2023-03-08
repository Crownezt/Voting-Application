package com.martinso.votingapp.candidate.data.model;

import com.martinso.votingapp.election.data.model.Election;
import com.martinso.votingapp.userdetails.data.model.UserDetails;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private UserDetails candidateProfile;
    private String politicalParty;
    private String achievement;
    @OneToOne(cascade = CascadeType.ALL)
    private Election election;
}
