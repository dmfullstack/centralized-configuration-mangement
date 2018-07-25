package st.malike.message.summary.service;

import java.util.Date;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @autor malike_st
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

  @Spy
  @InjectMocks
  private MessageService messageService;
  @Mock
  private MongoTemplate mongoTemplate;
  private String param;
  private String channel;
  private Date startDate;
  private Date endDate;

  @Before
  public void setUp() throws Exception {
    param = "search";
    channel = "email";
    startDate = new DateTime().minusDays(1).withTimeAtStartOfDay().toDate();
    startDate = new DateTime().withTimeAtStartOfDay().toDate();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void countSearchMessage() {
    messageService.countSearchMessage(param);
    Mockito.verify(mongoTemplate, Mockito.times(1)).count(Mockito.any(),
        Mockito.anyString());
  }

  @Test
  public void searchMessage() {
    messageService.searchMessage(param, 0, 10);
    Mockito.verify(mongoTemplate, Mockito.times(1))
        .find(Mockito.any(), Mockito.any(), Mockito.anyString());
  }

  @Test
  public void messageSummary() {
    messageService.messageSummary(channel, startDate, endDate);
    Mockito.verify(mongoTemplate, Mockito.times(1))
        .mapReduce(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
  }
}