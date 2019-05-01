package logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();

        eventRepository.findAll().forEach(events::add);

        return events;
    }

    public Optional<Event> getEventById(String id) {
        return eventRepository.findById(id);
    }

    public void addEvent(Event event) {
        eventRepository.save(event);
    }
}