package com.carbonara.karateboot.repos;

import com.carbonara.karateboot.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("clubRepository")
//public interface ClubRepository extends CrudRepository<Club, Integer> {
public interface ClubRepository extends JpaRepository<Club, Integer>{
    public Club findByName(String name);
}