package logger;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface EventRepository extends CrudRepository<Event, String> {
    Optional<Event> findById(String id);
}