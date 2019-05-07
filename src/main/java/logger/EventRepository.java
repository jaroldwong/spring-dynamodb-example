package logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

@Repository
public class EventRepository {
    @Autowired
    private DynamoDBMapper mapper;

    public void save(Event event) {
        mapper.save(event);
    }

    public List<Event> findAll() {
        return mapper.scan(Event.class, new DynamoDBScanExpression());
    }
}