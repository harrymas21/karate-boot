package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Event;
import com.carbonara.karateboot.models.EventRegister;
import com.carbonara.karateboot.models.UserInfo;

public interface EventService {
    Iterable<Event> listAllEvents();
    Event getEventById(Integer id);
    Event saveEvent(Event event);
    EventRegister saveRegistration(EventRegister eventRegister);
    EventRegister findByEventAndUser(Event event, UserInfo user);
    void deleteEvent(Integer id);
    Event findEventByName(String name);
}
