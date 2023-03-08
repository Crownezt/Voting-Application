package com.martinso.votingapp.candidate.service;

import com.martinso.votingapp.candidate.data.dto.request.CandidateDto;
import com.martinso.votingapp.candidate.data.dto.response.CandidateResponse;
import com.martinso.votingapp.candidate.data.model.Candidate;

import java.util.List;

public interface CandidateService {

    CandidateResponse createCandidate(CandidateDto candidate);
    List<Candidate> getAllCandidates();
    List<Candidate> getCandidatesByParty(String party);
}
