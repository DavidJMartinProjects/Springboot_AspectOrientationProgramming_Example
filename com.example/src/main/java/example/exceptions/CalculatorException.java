package example.exceptions;

public abstract class CalculatorException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private final String internalErrorCode;
	private final String userMessage;
	
	public CalculatorException(String internalErrorCode, String userMessage) {
		super();
		this.internalErrorCode = internalErrorCode;
		this.userMessage = userMessage;
	}
	
	public String getInternalErrorCode() {	
		return internalErrorCode;
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	
}
