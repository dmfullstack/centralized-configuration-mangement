package st.malike.message.summary.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @autor malike_st
 */
@Service
@RefreshScope
public class MessageService {

  @Value("${map.function}")
  private String MAP_SCRIPT;
  @Value("${reduce.function}")
  private String REDUCE_SCRIPT;
  @Value("${spring.data.mongodb.collection}")
  private String MESSAGE_COLLECTION;
  @Autowired
  private MongoTemplate mongoTemplate;

  public long countSearchMessage(String param) {
    Query query = new Query();
    Criteria idCrit = Criteria.where("messageId").regex(param);
    Criteria referenceCrit = Criteria.where("reference").regex(param);
    Criteria subjectCrit = Criteria.where("subject").regex(param);
    Criteria recipientCrit = Criteria.where("recipient").regex(param);
    query.addCriteria(new Criteria().orOperator(new Criteria[]{idCrit, referenceCrit, subjectCrit,
        recipientCrit})).with(new Sort(Direction.ASC, new String[]{"dateCreated"}));
    return mongoTemplate.count(query, MESSAGE_COLLECTION);
  }

  public List<Map> searchMessage(String param, Integer offset, Integer limit) {
    Query query = new Query();
    Criteria idCrit = Criteria.where("messageId").regex(param);
    Criteria referenceCrit = Criteria.where("reference").regex(param);
    Criteria subjectCrit = Criteria.where("subject").regex(param);
    Criteria recipientCrit = Criteria.where("recipient").regex(param);
    query.addCriteria(new Criteria().orOperator(new Criteria[]{idCrit, referenceCrit, subjectCrit,
        recipientCrit})).with(new Sort(Direction.ASC, new String[]{"dateCreated"}));
    query.skip(offset).limit(limit);
    return mongoTemplate.find(query, Map.class, MESSAGE_COLLECTION);
  }

  public Iterator messageSummary(String channel, Date startDate, Date endDate) {
    Query query = new Query();
    query.addCriteria(Criteria.where("reference").regex(channel));
    query.addCriteria(Criteria.where("dateCreated").gte(startDate).lte(endDate));
    return mongoTemplate.mapReduce(query, MESSAGE_COLLECTION, MAP_SCRIPT,
        REDUCE_SCRIPT, Map.class).iterator();

  }
}
