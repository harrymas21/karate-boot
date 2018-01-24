package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Club;

public interface ClubService {
    Iterable<Club> listAllClubs();
    Club getClubById(Integer id);
    Club getClubByName(String name);
    Club saveClub(Club club);
    void deleteClub(Integer id);
}
