package example.exceptions;

public class NumberExceedsAllowedLimitException extends CalculatorException {

	private static final long serialVersionUID = 1L;
	private final static String internalErrorCode = "Number exceeds allowed value.";
	private final static String userMessage = "Number exceeds allowed value. Please try again with a valid number.";
	
	public NumberExceedsAllowedLimitException() {
		super(internalErrorCode, userMessage);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getInternalerrorcode() {
		return internalErrorCode;
	}

	public static String getUsermessage() {
		return userMessage;
	}

}
