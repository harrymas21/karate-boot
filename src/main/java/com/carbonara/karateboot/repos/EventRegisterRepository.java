package com.carbonara.karateboot.repos;

import com.carbonara.karateboot.models.Event;
import com.carbonara.karateboot.models.EventRegister;
import com.carbonara.karateboot.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("erRepository")
public interface EventRegisterRepository extends JpaRepository<EventRegister, Integer>{
    //@Query("SELECT e FROM EventRegister e WHERE e.eventid = :eventId AND e.userid =:userId")
    EventRegister findByEventAndUser(Event event, UserInfo user);
}
