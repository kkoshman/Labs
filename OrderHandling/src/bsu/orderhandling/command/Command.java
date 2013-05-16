package bsu.orderhandling.command;

import java.util.HashMap;
import java.util.Map;

public abstract class Command {
	private CommandMemento mState;
	public abstract UserMessage execute(); 
	public abstract UserMessage revert();
	
	public void setState(ICommandState pCommandState) {
		if (pCommandState instanceof CommandMemento) {
			mState = (CommandMemento)pCommandState;
		}
	}
	public ICommandState getState() {
		return mState;
	}
	public ICommandState returnState(Map<String, Object> pParams) {
		CommandMemento state = new CommandMemento();
		state.params.putAll(pParams);
		return state;
	}
	
	protected class CommandMemento implements ICommandState {
		public static final String ORDER = "order";
		public static final String PRODUCT = "product";
		public static final String QUANTITY = "qty";
		public static final String SHIPPING_INFO = "shipInfo";
		public static final String BILLING_INFO = "billInfo";
		
		public Map<String, Object> params = new HashMap<String, Object>();
	}
}
