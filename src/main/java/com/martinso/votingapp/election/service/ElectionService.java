package com.martinso.votingapp.election.service;

import com.martinso.votingapp.election.dto.request.ElectionRequest;
import com.martinso.votingapp.election.dto.response.ElectionResponse;

public interface ElectionService {
    ElectionResponse registerElection(ElectionRequest request);
}
