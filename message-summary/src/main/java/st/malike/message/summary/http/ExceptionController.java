package st.malike.message.summary.http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import st.malike.message.summary.exception.MissingParameterException;
import st.malike.message.summary.util.Enums;
import st.malike.message.summary.util.JSONResponse;

/**
 * @autor malike_st
 */
@Controller
@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(MissingParameterException.class)
  @ResponseBody
  public JSONResponse missingParameterException(MissingParameterException e) {
    JSONResponse jSONResponse = new JSONResponse();
    jSONResponse.setStatus(false);
    jSONResponse.setMessage(Enums.JSONResponseMessage.MISSING_DATA_REQUIRED.toString());
    jSONResponse.setResult(e.toString());
    return jSONResponse;
  }

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public JSONResponse exception(Exception e) {
    JSONResponse jSONResponse = new JSONResponse();
    jSONResponse.setStatus(false);
    jSONResponse.setMessage(Enums.JSONResponseMessage.SERVER_ERROR.toString());
    jSONResponse.setResult(e.toString());
    return jSONResponse;
  }


}
