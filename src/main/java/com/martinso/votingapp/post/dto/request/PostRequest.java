package com.martinso.votingapp.post.dto.request;

import com.martinso.votingapp.candidate.data.model.Candidate;
import com.martinso.votingapp.election.data.model.Election;
import com.martinso.votingapp.office.data.model.Office;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostRequest {
    private Candidate contestant;
    private Office runningPost;
    private Election election;
}
