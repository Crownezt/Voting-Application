package com.martinso.votingapp.candidate.data.repository;

import com.martinso.votingapp.candidate.data.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findByPoliticalParty(String party);

}
