package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Club;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ClubService {
    Iterable<Club> listAllClubs();
    Club getClubById(Integer id);
    Club getClubByName(String name);
    Club saveClub(Club club);
    void deleteClub(Integer id);
    int getClubBalance(Integer id);
}
