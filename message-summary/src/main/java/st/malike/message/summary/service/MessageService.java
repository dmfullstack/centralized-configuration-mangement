package st.malike.message.summary.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @autor malike_st
 */
@Service
public class MessageService {

  private final String MAP_SCRIPT = "";
  private final String REDUCE_SCRIPT = "";
  @Autowired
  private MongoTemplate mongoTemplate;

  public int countSearchMessage(String param) {
    return 0;
  }

  public List<Object> searchMessage(String param, Integer offset, Integer limit) {
    return null;
  }

  public List<Map> messageSummary(String channel, String startDate, String endDate) {
    return null;
  }
}
