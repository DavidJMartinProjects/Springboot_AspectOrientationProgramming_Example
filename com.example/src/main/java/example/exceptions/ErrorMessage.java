package example.exceptions;

public class ErrorMessage {

	private String internalErrorCode;
	private String userMessage;
	
	public ErrorMessage(String internalErrorCode, String userMessage) {
		this.internalErrorCode = internalErrorCode;
		this.userMessage = userMessage;
	}
	
	public String getInternalErrorCode() {
		return internalErrorCode;
	}

	public void setInternalErrorCode(String internalErrorCode) {
		this.internalErrorCode = internalErrorCode;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	
}




