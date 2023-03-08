package com.martinso.votingapp.contollers;

import com.martinso.votingapp.candidate.data.dto.request.CandidateDto;
import com.martinso.votingapp.candidate.data.dto.response.CandidateResponse;
import com.martinso.votingapp.candidate.data.model.Candidate;
import com.martinso.votingapp.candidate.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/candidate")
public class CandidateController {
    private final CandidateService service;

    @Autowired
    public CandidateController(CandidateService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCandidate(@RequestBody CandidateDto candidate) {
        CandidateResponse response = service.createCandidate(candidate);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public List<Candidate> getAllCandidates() {
        return service.getAllCandidates();
    }

    @GetMapping("/party{party}")
    public List<Candidate> getCandidateByParty(@PathVariable String party) {
        return service.getCandidatesByParty(party);
    }
}
