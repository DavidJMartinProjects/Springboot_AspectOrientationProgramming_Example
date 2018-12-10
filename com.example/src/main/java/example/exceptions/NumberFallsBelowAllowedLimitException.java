package example.exceptions;

public class NumberFallsBelowAllowedLimitException extends CalculatorException {

	private static final long serialVersionUID = 1L;
	private final static String internalErrorCode = "Number exceeds allowed value.";
	private final static String userMessage = "Number exceeds allowed value. Please try again with a valid number.";
	
	public NumberFallsBelowAllowedLimitException() {
		super(internalErrorCode, userMessage);
	}
	
	public NumberFallsBelowAllowedLimitException(String internalErrorCode, String userMessage) {
		super(internalErrorCode, userMessage);
	}

}
