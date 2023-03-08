package com.martinso.votingapp.office.service;

import com.martinso.votingapp.office.dto.request.OfficeRequest;
import com.martinso.votingapp.office.dto.response.OfficeResponse;

public interface OfficeService {

    OfficeResponse createOffice(OfficeRequest request);
    void deleteOffice(Long officeId);
}
