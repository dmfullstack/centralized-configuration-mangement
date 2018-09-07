package st.malike.message.summary.http;

import java.text.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import st.malike.message.summary.exception.InvalidAggregationException;
import st.malike.message.summary.exception.MissingParameterException;
import st.malike.message.summary.util.Enums;
import st.malike.message.summary.util.JSONResponse;

/**
 * @autor malike_st
 */
@Controller
@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(ParseException.class)
  @ResponseBody
  public JSONResponse parseException(ParseException e) {
    JSONResponse jSONResponse = new JSONResponse();
    jSONResponse.setStatus(false);
    jSONResponse.setMessage(Enums.JSONResponseMessage.PARAMETER_MISMATCH.toString());
    jSONResponse.setResult(e.toString());
    return jSONResponse;
  }

  @ExceptionHandler(MissingParameterException.class)
  @ResponseBody
  public JSONResponse missingParameterException(MissingParameterException e) {
    JSONResponse jSONResponse = new JSONResponse();
    jSONResponse.setStatus(false);
    jSONResponse.setMessage(Enums.JSONResponseMessage.MISSING_DATA_REQUIRED.toString());
    jSONResponse.setResult(e.toString());
    return jSONResponse;
  }

  @ExceptionHandler(InvalidAggregationException.class)
  @ResponseBody
  public JSONResponse invalidAggregationException(InvalidAggregationException e) {
    JSONResponse jSONResponse = new JSONResponse();
    jSONResponse.setStatus(false);
    jSONResponse.setMessage(Enums.JSONResponseMessage.AGGREGATION_EXCEPTION.toString());
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
