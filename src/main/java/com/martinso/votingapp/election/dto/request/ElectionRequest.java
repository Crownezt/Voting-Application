package com.martinso.votingapp.election.dto.request;

import com.martinso.votingapp.office.data.model.Office;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElectionRequest {
    private String electionName;
    private String startedAt;
    private String endedAt;
    private String politicalParty;
}
