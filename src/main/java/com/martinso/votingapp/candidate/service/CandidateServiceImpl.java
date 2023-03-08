package com.martinso.votingapp.candidate.service;

import com.martinso.votingapp.candidate.data.dto.request.CandidateDto;
import com.martinso.votingapp.candidate.data.dto.response.CandidateResponse;
import com.martinso.votingapp.candidate.data.model.Candidate;
import com.martinso.votingapp.candidate.data.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CandidateServiceImpl implements CandidateService{

    private final CandidateRepository repository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository repository) {
        this.repository = repository;
    }

    @Override
    public CandidateResponse createCandidate(CandidateDto candidate) {
        Candidate savedCandidate = Candidate.builder()
                .candidateProfile(candidate.getCandidateProfile())
                .achievement(candidate.getAchievement())
                .election(candidate.getElection())
                .politicalParty(candidate.getPoliticalParty())
                .build();
        Candidate saved = repository.save(savedCandidate);
        log.info("Saved candidate->{}", saved);
        return getCandidateResponse(saved);
    }

    private CandidateResponse getCandidateResponse(Candidate saved) {
        return CandidateResponse.builder()
                .id(saved.getId())
                .code(HttpStatus.CREATED.value())
                .isSuccess(true)
                .message("candidate register successfully")
                .build();
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return repository.findAll();
    }

    @Override
    public List<Candidate> getCandidatesByParty(String party) {
        return repository.findByPoliticalParty(party);
    }
}
