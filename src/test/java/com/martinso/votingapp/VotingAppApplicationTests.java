package com.martinso.votingapp;

import com.martinso.votingapp.data.model.Gender;
import com.martinso.votingapp.userdetails.dto.request.CreateUserDetailsRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@ExtendWith(MockitoExtension.class)
class VotingAppApplicationTests {

    @Autowired
    private MockMvc mvc;
    private ObjectMapper mapper;

    @Test
    void createUser() throws Exception {
        CreateUserDetailsRequest request = getUserRequest();
        String collectRequest = mapper.writeValueAsString(request);
        mvc.perform(post("/api/vi/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(collectRequest))
                .andExpect(status().isCreated());

    }

    private CreateUserDetailsRequest getUserRequest() {
        return CreateUserDetailsRequest.builder()
                .firstName("Martins")
                .lastName("Jojolola")
                .middleName("Oluwaseun")
                .email("mail")
                .password("passwordEncoder.encode(request.getPassword()")
                .phoneNumber("request.getPhoneNumber()")
                .age(23)
                .username("request.getUsername()")
                .NIN("request.getNIN()")
                .VIN("request.getVIN()")
                .gender(Gender.MALE)
                .build();
    }

}
