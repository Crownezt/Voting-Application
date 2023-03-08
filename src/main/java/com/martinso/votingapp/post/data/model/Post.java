package com.martinso.votingapp.post.data.model;

import com.martinso.votingapp.candidate.data.model.Candidate;
import com.martinso.votingapp.office.data.model.Office;
import com.martinso.votingapp.election.data.model.Election;
import com.martinso.votingapp.userdetails.data.model.UserDetails;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Candidate contestant;
    @OneToOne(cascade = CascadeType.ALL)
    private Office runningPost;
    @OneToOne(cascade = CascadeType.ALL)
    private Election election;
}
