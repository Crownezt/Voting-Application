package com.martinso.votingapp.office.data.repository;

import com.martinso.votingapp.office.data.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}
