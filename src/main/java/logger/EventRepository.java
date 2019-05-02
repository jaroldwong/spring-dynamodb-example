package logger;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface EventRepository extends CrudRepository<Event, EventId> {
    List<Event> findByLogEntityId(String logEntityId);
}