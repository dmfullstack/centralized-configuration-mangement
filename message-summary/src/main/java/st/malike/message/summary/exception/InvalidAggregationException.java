package st.malike.message.summary.exception;

/**
 * @autor malike_st
 */
public class InvalidAggregationException extends Exception {

  public InvalidAggregationException() {
  }

  public InvalidAggregationException(String message) {
    super(message);
  }

  public InvalidAggregationException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidAggregationException(Throwable cause) {
    super(cause);
  }

  public InvalidAggregationException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
