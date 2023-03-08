package com.martinso.votingapp.office.service;

import com.martinso.votingapp.office.dto.request.OfficeRequest;
import com.martinso.votingapp.office.dto.response.OfficeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OfficeServiceImplTest {

    @Autowired
    private OfficeService service;

    @Test
    public void createOffice() {
        OfficeRequest office = new OfficeRequest();
        office.setOfficeName("Presidential");
        OfficeResponse response = service.createOffice(office);
        assertThat(response).isNotNull();
        assertThat(response.getCode()).isEqualTo(HttpStatus.CREATED.value());

    }

    @Test
    void deleteOffice() {

    }
}