package com.martinso.votingapp.castVote.dto.request;

import com.martinso.votingapp.candidate.data.model.Candidate;
import com.martinso.votingapp.election.data.model.Election;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class VoteRequest {
    private Candidate candidateName;
    private Election election;

}
