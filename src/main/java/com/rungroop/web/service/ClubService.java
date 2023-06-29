package com.rungroop.web.service;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;

import java.util.List;

public interface ClubService {
    public List<ClubDto> findAllClubs();
    public Club saveClub(ClubDto clubDto);

    ClubDto findClubById(Long clubId);

    void updateClub(ClubDto clubDto);

    void delete(Long clubId);
    List<ClubDto> searchClubs(String query);
}
