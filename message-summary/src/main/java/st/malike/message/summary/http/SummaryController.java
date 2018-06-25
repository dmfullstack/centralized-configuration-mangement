package st.malike.message.summary.http;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import st.malike.message.summary.util.Enums;
import st.malike.message.summary.util.JSONResponse;

/**
 * @autor malike_st
 */
@Controller
public class SummaryController extends ExceptionController {

  @RequestMapping(value = {
      "/message/search"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public JSONResponse searchMessage(@RequestBody Object data, HttpServletResponse response,
      HttpServletRequest request){
    JSONResponse jSONResponse = new JSONResponse();
    Map<String, Object> dataHash = (Map<String, Object>) data;
    String param = null;
    Integer offset = 0;
    Integer limit = 100;
    jSONResponse.setStatus(true);
    jSONResponse.setCount(1);
    jSONResponse.setResult(null);
    jSONResponse.setMessage(Enums.JSONResponseMessage.SUCCESS.toString());
    return jSONResponse;
  }

}