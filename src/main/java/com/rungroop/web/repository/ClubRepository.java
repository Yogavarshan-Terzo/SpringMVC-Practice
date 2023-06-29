package com.rungroop.web.repository;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club,Long> {
    Optional<Club> findByTitle(String url);
    @Query("SELECT C FROM Club C WHERE C.title LIKE CONCAT('%',:query,'%')")
    List<Club> searchClubs(String query);

}
