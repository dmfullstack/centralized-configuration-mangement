package st.malike.message.summary.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @autor malike_st
 */
@Service
public class MessageService {

  @Autowired
  private MongoTemplate mongoTemplate;

  public int countSearchMessage(String param) {
    return 0;
  }

  public List<Object> searchMessage(String param, Integer offset, Integer limit) {
    return null;
  }
}
