package com.martinso.votingapp.election.service;

import com.martinso.votingapp.election.data.model.Election;
import com.martinso.votingapp.election.data.repository.ElectionRepository;
import com.martinso.votingapp.election.dto.request.ElectionRequest;
import com.martinso.votingapp.election.dto.response.ElectionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
//@AllArgsConstructor
@Slf4j
public class ElectionServiceImpl implements ElectionService {


    private final ElectionRepository repository;

    @Autowired
    public ElectionServiceImpl(ElectionRepository repository) {
        this.repository = repository;
    }

    @Override
    public ElectionResponse registerElection(ElectionRequest request) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Election election = Election.builder()
                .name(request.getElectionName())
                .createdAt(LocalDate.parse(request.getStartedAt(), formatter))
                .endedAt(LocalDate.parse(request.getEndedAt(), formatter))
                .build();
        Election saved = repository.save(election);
        log.info("Saved -> {}", saved);
        return getElectionResponse(saved);
    }

    private ElectionResponse getElectionResponse(Election election){
        return ElectionResponse.builder()
                .id(election.getId())
                .message("Elections created successfully")
                .isSuccess(true)
                .code(HttpStatus.CREATED.value())
                .build();
    }
}
