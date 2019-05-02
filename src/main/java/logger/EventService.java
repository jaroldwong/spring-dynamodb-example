package logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();

        eventRepository.findAll().forEach(events::add);

        return events;
    }

    public List<Event> getEventsByLogEntityId(String logEntityId) {
        return eventRepository.findByLogEntityId(logEntityId);
    }

    public void addEvent(Event event) {
        eventRepository.save(event);
    }
}