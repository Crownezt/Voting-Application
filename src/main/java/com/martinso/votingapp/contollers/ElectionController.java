package com.martinso.votingapp.contollers;

import com.martinso.votingapp.election.dto.request.ElectionRequest;
import com.martinso.votingapp.election.dto.response.ElectionResponse;
import com.martinso.votingapp.election.service.ElectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/election")
public class ElectionController {

    private final ElectionService service;

    @PostMapping("/create")
    public ResponseEntity<?> register(@RequestBody ElectionRequest request){
        ElectionResponse response = service.registerElection(request);
        return ResponseEntity.ok().body(response);
    }

}
