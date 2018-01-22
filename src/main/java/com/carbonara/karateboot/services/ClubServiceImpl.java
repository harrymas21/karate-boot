package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Club;
import com.carbonara.karateboot.repos.ClubRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl implements ClubService {
    
private ClubRepository clubRepository;

@PersistenceContext	
    private EntityManager entityManager;

@Autowired
    public void setClubRepository(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
    
    
    @Override
    public Iterable<Club> listAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Club getClubById(Integer id) {
        return clubRepository.findOne(id);
    }
    
    @Override
    public Club getClubByName(String name) {
        return clubRepository.findByName(name);
    }

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public void deleteClub(Integer id) {
        clubRepository.delete(id);
    }
    
    @Override
    public int getClubBalance(Integer id) {
        int balance = entityManager.createQuery("SELECT b.balance FROM ClubStatement b WHERE club_id=? ORDER BY date DESC LIMIT 1")
				.setParameter(1, id).getFirstResult();
        return balance;
    }
}
