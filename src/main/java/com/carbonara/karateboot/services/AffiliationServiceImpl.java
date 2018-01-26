package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Affiliation;
import com.carbonara.karateboot.models.Club;
import com.carbonara.karateboot.repos.AffiliationRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffiliationServiceImpl implements AffiliationService {

    private AffiliationRepository affiliationRepository;
    
    @Autowired
    public void setAffiliationRepository(AffiliationRepository affiliationRepository) {
        this.affiliationRepository = affiliationRepository;
    }
    
    @PersistenceContext	
    private EntityManager entityManager;

    @Override
    public Iterable<Affiliation> findByClub(Club club) {
        return affiliationRepository.findByClub(club);
    }

    @Override
    public Affiliation saveAffiliation(Affiliation affiliation) {
        int oldBalance = getClubBalance(affiliation.getClub().getId());
        //int newBalance = (affiliation.getBalance());
        //if(oldBalance>0){
            affiliation.setBalance((oldBalance + affiliation.getAmount()) - affiliation.getPaid());
           // return affiliationRepository.save(affiliation);
       // }else{
           // affiliation.setBalance(affiliation.getBalance());
            return affiliationRepository.save(affiliation);
      //  }  
    }

    @Override
    public Iterable<Affiliation> listAllStatements(Date startDate, Date endDate) {
        return affiliationRepository.findByDateBetweenOrderByDateDesc(startDate, endDate);
    }
    
    @Override
    public int getClubBalance(Integer id) {
        List<Affiliation> clubList = entityManager.createQuery("SELECT a FROM Affiliation a WHERE club_id=? ORDER BY date DESC")
				.setParameter(1, id).setMaxResults(1).getResultList();
        return clubList.get(0).getBalance();
    }

    @Override
    public Iterable<Affiliation> listAllStatementsByClub(Date startDate, Date endDate, Club club) {
        return affiliationRepository.findByDateBetweenAndClubOrderByDateDesc(startDate, endDate,club);
    }

    @Override
    public Affiliation getStatementByCode(String code) {
        return affiliationRepository.findByTransactionCode(code);
    }

    @Override
    public Iterable<Affiliation> listAllClubsBalance() {
        List<Affiliation> clubList = entityManager.createQuery("SELECT a FROM Affiliation"
                + " a WHERE a.date=(SELECT MAX(b.date) FROM Affiliation b where b.club = a.club)").getResultList();
        return clubList;
    }
}
