package com.rungroop.web.service;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;

import java.util.List;

public interface ClubService {
    public List<ClubDto> findAllClubs();
    public Club saveClub(Club club);

    ClubDto findClubById(Long clubId);

    void updateClub(ClubDto clubDto);

}
