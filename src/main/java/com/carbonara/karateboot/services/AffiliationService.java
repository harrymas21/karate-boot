package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Affiliation;
import com.carbonara.karateboot.models.Club;
import java.util.Date;

public interface AffiliationService {
    Iterable<Affiliation> listAllStatements(Date startDate, Date endDate);
    Iterable<Affiliation> listAllStatementsByClub(Date startDate, Date endDate, Club club);
    Iterable<Affiliation> findByClub(Club club);
    Affiliation saveAffiliation(Affiliation Affiliation);
    Affiliation getStatementByCode(String code);
    Iterable<Affiliation> listAllClubsBalance();
    int getClubBalance(Integer id);
}