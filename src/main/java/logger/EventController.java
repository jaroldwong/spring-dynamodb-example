package logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping("/status")
    public HashMap<String, String> status() {
        HashMap<String, String> status = new HashMap<>();

        status.put("status", "ok");

        return status;
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @RequestMapping("/event/{id}")
    public Optional<Event> getEvent(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
    }

}