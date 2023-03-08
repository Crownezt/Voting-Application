package com.martinso.votingapp.office.service;

import com.martinso.votingapp.office.data.model.Office;
import com.martinso.votingapp.office.data.repository.OfficeRepository;
import com.martinso.votingapp.office.dto.request.OfficeRequest;
import com.martinso.votingapp.office.dto.response.OfficeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository repository;

    @Autowired
    public OfficeServiceImpl(OfficeRepository repository) {
        this.repository = repository;
    }

    @Override
    public OfficeResponse createOffice(OfficeRequest request) {
        Office office = Office.builder()
                .name(request.getOfficeName())
                .build();
        Office saved = repository.save(office);
        log.info("Office saved ->{}", office);
        return getOfficeResponse(saved);
    }

    @Override
    public void deleteOffice(Long officeId) {
        repository.deleteById(officeId);
    }


    private OfficeResponse getOfficeResponse(Office office){
        return OfficeResponse.builder()
                .id(office.getId())
                .message("Office created successfully")
                .isSuccess(true)
                .code(HttpStatus.CREATED.value())
                .build();
    }

}
