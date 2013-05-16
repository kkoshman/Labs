package bsu.orderhandling.command;

public class UserMessage {
	@Override
	public String toString() {
		return mMessage;
	}
	protected String mMessage;
	protected UserMessageType mType;
	
	public String getMessage() {
		return mMessage;
	}
	public void setMessage(String message) {
		mMessage = message;
	}
	public UserMessageType getType() {
		return mType;
	}
	public void setType(UserMessageType type) {
		mType = type;
	}
}
