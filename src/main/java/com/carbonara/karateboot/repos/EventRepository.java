package com.carbonara.karateboot.repos;

import com.carbonara.karateboot.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("eventRepository")
public interface EventRepository extends CrudRepository<Event, Integer> {
    Iterable<Event> findAllByOrderByDateDesc();
}
