package logger;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

/**
 * Composite Key to support a HASH+RANGE key of DynamoDB in Spring-Data
 */
@DynamoDBDocument
public class EventId implements Serializable {
  private static final long serialVersionUID = 1L;

  @DynamoDBRangeKey(attributeName = "id")
  private String id;

  @DynamoDBHashKey(attributeName = "logEntityId")
  private String logEntityId;

  public EventId() {}

  public EventId(String id, String logEntityId) {
    this.id = id;
    this.logEntityId = logEntityId;
  }

  public String getLogEntityId() {
    return logEntityId;
  }

  public void setLogEntityId(String logEntityId) {
    this.logEntityId = logEntityId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    EventId eventId = (EventId) o;
    if (!getLogEntityId().equals(eventId.getLogEntityId()))
      return false;
    return getId().equals(eventId.getId());
  }

  @Override
  public int hashCode() {
    int result = getLogEntityId().hashCode();
    result = 31 * result + getId().hashCode();
    return result;
  }
}