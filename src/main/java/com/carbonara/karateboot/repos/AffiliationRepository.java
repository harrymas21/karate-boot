package com.carbonara.karateboot.repos;

import com.carbonara.karateboot.models.Affiliation;
import com.carbonara.karateboot.models.Club;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("affiliationRepository")
public interface AffiliationRepository extends JpaRepository<Affiliation, Integer>{
    public Iterable<Affiliation> findByClub(Club club);
    public Iterable<Affiliation> findByDateBetweenOrderByDateDesc(Date startDate, Date endDate);
    public Affiliation findByTransactionCode(String code);
    public Iterable<Affiliation> findByDateBetweenAndClubOrderByDateDesc(Date startDate, Date endDate,Club club);
}