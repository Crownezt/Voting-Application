package com.martinso.votingapp.candidate.data.dto.request;

import com.martinso.votingapp.election.data.model.Election;
import com.martinso.votingapp.userdetails.data.model.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CandidateDto {
    private UserDetails candidateProfile;
    private String politicalParty;
    private String achievement;
    private Election election;
}

