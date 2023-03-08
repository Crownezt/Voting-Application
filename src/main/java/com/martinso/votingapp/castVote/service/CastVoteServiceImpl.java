package com.martinso.votingapp.castVote.service;

import com.martinso.votingapp.candidate.data.model.Candidate;
import com.martinso.votingapp.castVote.data.model.CastVote;
import com.martinso.votingapp.castVote.data.repository.CastVoteRepository;
import com.martinso.votingapp.castVote.dto.request.VoteRequest;
import com.martinso.votingapp.castVote.dto.response.VoteResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class CastVoteServiceImpl implements CastVoteService {

    private final CastVoteRepository repository;

    @Autowired
    public CastVoteServiceImpl(CastVoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public VoteResponse createVote(VoteRequest request) {
        CastVote castVote = new CastVote();
        castVote.setElection(request.getElection());
        castVote.setCandidateName(request.getCandidateName());
        castVote.setCreatedAt(LocalDateTime.now());
        castVote.setEndedAt(LocalDateTime.now());
        CastVote saved = repository.save(castVote);
        log.info("saved -> {}", saved);
        return getVoteResponse(castVote);
    }


    @Override
    public List<CastVote> getVotesByCandidate(Candidate candidateName) {
        return repository.findByCandidateName(candidateName);
    }

    @Override
    public List<CastVote> getVotesBetween(LocalDateTime start, LocalDateTime end) {
        return repository.findCastVoteByCreatedAtAndEndedAt(start, end);
    }

    @Override
    public List<CastVote> getAllVote() {
        return repository.findAll();
    }

    private VoteResponse getVoteResponse(CastVote castVote){
        return VoteResponse.builder()
                .id(castVote.getId())
                .message("Vote created successfully")
                .isSuccess(true)
                .code(HttpStatus.CREATED.value())
                .build();
    }
}
