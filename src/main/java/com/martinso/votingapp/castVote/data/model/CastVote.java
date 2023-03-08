package com.martinso.votingapp.castVote.data.model;

import com.martinso.votingapp.candidate.data.model.Candidate;
import com.martinso.votingapp.election.data.model.Election;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CastVote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Candidate candidateName;
    @OneToOne(cascade = CascadeType.ALL)
    private Election election;
    private LocalDateTime createdAt;
    private LocalDateTime endedAt;
}
