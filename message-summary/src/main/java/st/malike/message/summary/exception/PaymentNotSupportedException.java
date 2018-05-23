package st.malike.message.summary.exception;

/**
 * @autor malike_st
 */
public class PaymentNotSupportedException extends Exception {

  public PaymentNotSupportedException() {
  }

  public PaymentNotSupportedException(String message) {
    super(message);
  }

  public PaymentNotSupportedException(String message, Throwable cause) {
    super(message, cause);
  }

  public PaymentNotSupportedException(Throwable cause) {
    super(cause);
  }

  public PaymentNotSupportedException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
