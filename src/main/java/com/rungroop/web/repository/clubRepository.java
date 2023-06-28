package com.rungroop.web.repository;

import com.rungroop.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface clubRepository extends JpaRepository<Club,Long> {
    Optional<Club> findByTitle(String url);
}
