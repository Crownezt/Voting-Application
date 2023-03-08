package com.martinso.votingapp.userdetails.data.repository;

import com.martinso.votingapp.userdetails.data.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
     Optional<UserDetails> findUserByUsername(String username);
     Optional<UserDetails> findUserByEmail(String email);
}
