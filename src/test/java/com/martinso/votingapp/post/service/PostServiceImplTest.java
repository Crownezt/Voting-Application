package com.martinso.votingapp.post.service;

import com.martinso.votingapp.candidate.data.model.Candidate;
import com.martinso.votingapp.data.model.Gender;
import com.martinso.votingapp.election.data.model.Election;
import com.martinso.votingapp.office.data.model.Office;
import com.martinso.votingapp.post.dto.request.PostRequest;
import com.martinso.votingapp.post.dto.response.PostResponse;
import com.martinso.votingapp.userdetails.data.model.UserDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    private PostService service;

    @Test
    void createPost() {
        Election election = Election.builder()
                .name("National Election")
                .build();
        UserDetails details = UserDetails.builder()
                .firstName("Martins")
                .age(34)
                .gender(Gender.MALE)
                .lastName("Jojolola")
                .middleName("Oluwaseun").build();
        Candidate candidate = Candidate.builder()
                .politicalParty("PDP")
                .achievement("World election" +
                        "famous" +
                        "most runner" +
                        "Bala blu")
                .candidateProfile(details)
                .election(election).build();
        Office office = Office.builder()
                .name("President")
                .build();
        PostRequest request = new PostRequest();
        request.setRunningPost(office);
        request.setElection(election);
        request.setContestant(candidate);
        PostResponse response = service.createPost(request);
        assertThat(response).isNotNull();
        assertThat(response.getCode())
                .isEqualTo(HttpStatus.CREATED.value());
    }
}