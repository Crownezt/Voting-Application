package com.martinso.votingapp.castVote.service;

import com.martinso.votingapp.candidate.data.model.Candidate;
import com.martinso.votingapp.castVote.data.model.CastVote;
import com.martinso.votingapp.castVote.dto.request.VoteRequest;
import com.martinso.votingapp.castVote.dto.response.VoteResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface CastVoteService {

    VoteResponse createVote(VoteRequest request);
    List<CastVote> getVotesByCandidate(Candidate candidateName);
    List<CastVote> getVotesBetween(LocalDateTime start, LocalDateTime end);
    List<CastVote> getAllVote();
}
