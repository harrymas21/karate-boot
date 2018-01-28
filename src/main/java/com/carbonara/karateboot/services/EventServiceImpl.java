package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Event;
import com.carbonara.karateboot.models.EventRegister;
import com.carbonara.karateboot.models.UserInfo;
import com.carbonara.karateboot.repos.EventRegisterRepository;
import com.carbonara.karateboot.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    
private EventRepository eventRepository;
private EventRegisterRepository eventRegisterRepository;

@Autowired
    public void setEventRepository(EventRepository eventRepository, EventRegisterRepository eventRegisterRepository) {
        this.eventRepository = eventRepository;
        this.eventRegisterRepository = eventRegisterRepository;
    }
    
    @Override
    public Iterable<Event> listAllEvents() {
        return eventRepository.findAllByOrderByDateDesc();
    }

    @Override
    public Event getEventById(Integer id) {
        return eventRepository.findOne(id);
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Integer id) {
        eventRepository.delete(id);
    }
    
    @Override
    public EventRegister saveRegistration(EventRegister eventRegister) {
        return eventRegisterRepository.save(eventRegister);
    }

    @Override
    public EventRegister findByEventAndUser(Event event, UserInfo user) {
        return eventRegisterRepository.findByEventAndUser(event, user);
    }

    @Override
    public Event findEventByName(String name) {
        return eventRepository.findByName(name);
    }
}
