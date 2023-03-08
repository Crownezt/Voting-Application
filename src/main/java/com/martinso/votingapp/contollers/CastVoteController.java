package com.martinso.votingapp.contollers;

import com.martinso.votingapp.candidate.data.model.Candidate;
import com.martinso.votingapp.castVote.data.model.CastVote;
import com.martinso.votingapp.castVote.dto.request.VoteRequest;
import com.martinso.votingapp.castVote.dto.response.VoteResponse;
import com.martinso.votingapp.castVote.service.CastVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/vote")
public class CastVoteController {

    private final CastVoteService service;

    @Autowired
    public CastVoteController(CastVoteService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VoteRequest request){
        VoteResponse response = service.createVote(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public List<CastVote> getAllVotes() {
        return service.getAllVote();
    }

    @GetMapping("/candidate/{candidateId}")
    public List<CastVote> getVotesByCandidate(@PathVariable Long candidateId) {
        Candidate candidate = new Candidate();
        candidate.setId(candidateId);
        return service.getVotesByCandidate(candidate);
    }

    @GetMapping("/date")
    public List<CastVote> getVotesBetween(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                          @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return service.getVotesBetween(start, end);
    }
}
