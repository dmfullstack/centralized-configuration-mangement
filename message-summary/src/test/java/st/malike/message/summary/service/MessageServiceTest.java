package st.malike.message.summary.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @autor malike_st
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

  @InjectMocks
  @Spy
  private MessageService messageService;
  @Mock
  private MongoTemplate mongoTemplate;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void countSearchMessage() {
  }

  @Test
  public void searchMessage() {
  }

  @Test
  public void messageSummary() {
  }
}