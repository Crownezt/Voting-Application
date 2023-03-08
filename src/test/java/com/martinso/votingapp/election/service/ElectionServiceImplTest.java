package com.martinso.votingapp.election.service;

import com.martinso.votingapp.election.dto.request.ElectionRequest;
import com.martinso.votingapp.election.dto.response.ElectionResponse;
import com.martinso.votingapp.office.data.model.Office;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ElectionServiceImplTest {

    @Autowired
    private ElectionService electionService;

    @Test
    void testThatRegisterElectionWorks() {
        Office office = Office.builder()
                .name("Presidential")
//                .id(1L)
                .build();
        ElectionRequest request = new ElectionRequest();
        request.setElectionName("office");
        request.setStartedAt("2022-04-11");
        request.setEndedAt("2023-04-11");
        ElectionResponse response = electionService.registerElection(request);
        assertThat(response).isNotNull();
        assertThat(response.getCode())
                .isEqualTo(HttpStatus.CREATED.value());
    }


}