package com.martinso.votingapp.castVote.data.repository;

import com.martinso.votingapp.candidate.data.model.Candidate;
import com.martinso.votingapp.castVote.data.model.CastVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CastVoteRepository extends JpaRepository<CastVote, Long> {
    List<CastVote> findByCandidateName(Candidate candidateName);

    List<CastVote> findCastVoteByCreatedAtAndEndedAt(LocalDateTime start, LocalDateTime end);


}
