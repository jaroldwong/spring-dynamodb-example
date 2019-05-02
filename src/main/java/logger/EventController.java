package logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @RequestMapping(value = "/events/{logEntityId}", method = RequestMethod.GET)
    public List<Event> getEventsByLogEntityId(@PathVariable String logEntityId) {
        return eventService.getEventsByLogEntityId(logEntityId);
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public void addEvent(@RequestBody Event event) {
        // {
        //     id: generated,
        //     logEntityId: "application_asdf",
        //     entry: {
        //         loggedAt: "",
        //         message: "",
        //     }
        // }
        eventService.addEvent(event);
    }

}