package st.malike.message.summary.http;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import st.malike.message.summary.service.MessageService;
import st.malike.message.summary.util.Enums;
import st.malike.message.summary.util.JSONResponse;

/**
 * @autor malike_st
 */
@Controller
public class SummaryController extends ExceptionController {

  @Autowired
  private MessageService messageService;

  @RequestMapping(value = {
      "/message/search"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public JSONResponse searchMessage(@RequestBody Object data){
    JSONResponse jSONResponse = new JSONResponse();
    Map<String, Object> dataHash = (Map<String, Object>) data;
    String param = null;
    Integer offset = 0;
    Integer limit = 100;
    jSONResponse.setStatus(true);
    jSONResponse.setCount(messageService.countSearchMessage(param));
    jSONResponse.setResult(messageService.searchMessage(param,offset,limit));
    jSONResponse.setMessage(Enums.JSONResponseMessage.SUCCESS.toString());
    return jSONResponse;
  }

}