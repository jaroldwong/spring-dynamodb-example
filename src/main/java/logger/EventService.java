package logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

@Service
public class EventService {

    @Autowired
    DynamoDBMapper mapper;

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();

        eventRepository.findAll().forEach(events::add);

        return events;
    }

    public List<Event> getEventsByLogEntityId(String logEntityId) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(logEntityId));

        DynamoDBQueryExpression<Event> queryExpression = new DynamoDBQueryExpression<Event>()
                .withKeyConditionExpression("logEntityId = :val1").withExpressionAttributeValues(eav);

        List<Event> events = mapper.query(Event.class, queryExpression);

        return events;
    }

    public void addEvent(Event event) {
        eventRepository.save(event);
    }
}