package st.malike.message.summary.util;

import java.io.Serializable;

/**
 * @autor malike_st
 */
public class JSONResponse implements Serializable {

  private boolean status;
  private Object result;
  private String message;
  private long count;

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }
}
