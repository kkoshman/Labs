package bsu.orderhandling.request;

import java.util.HashMap;
import java.util.Map;

import bsu.orderhandling.command.Command;
import bsu.orderhandling.command.ICommandState;
import bsu.orderhandling.command.UserMessage;
import bsu.orderhandling.command.UserMessageType;
import bsu.orderhandling.command.order.AddProductCommand;
import bsu.orderhandling.command.order.RemoveProductCommand;
import bsu.orderhandling.command.order.RevertLastCommand;

public class RequestHandler {
	public static final String ADD_PRODUCT = "addProduct";
	public static final String REMOVE_PRODUCT = "removeProduct";
	public static final String REVERT_LAST_COMMAND = "revertLastCommand";
	
	private static RequestHandler instance = null;
	
	protected RequestHandler() {
		mCommandsMap = new HashMap<String, Command>();
		mCommandsMap.put(ADD_PRODUCT, AddProductCommand.getInstance());
		mCommandsMap.put(REMOVE_PRODUCT, RemoveProductCommand.getInstance());
		mCommandsMap.put(REVERT_LAST_COMMAND, RevertLastCommand.getInstance());
	}
	public static synchronized RequestHandler getInstance() {
		if (instance == null) {
			instance = new RequestHandler();
		}
		return instance;
	}
	
	protected Map<String, Command> mCommandsMap;
		
	public UserMessage handleRequest(Request pRequest) {
		UserMessage message = null;
		String commandName = pRequest.action;
		Command command = mCommandsMap.get(commandName);
		if (command != null) {
			ICommandState state = command.returnState(pRequest.params);
			command.setState(state);
			message = command.execute();
			boolean executionFault = message != null && message.getType() == UserMessageType.ERROR;
			if (!REVERT_LAST_COMMAND.equals(command) && !executionFault) {
				RequestHistoryLine historyLine = new RequestHistoryLine();
				historyLine.request = pRequest;
				historyLine.command = command;
				historyLine.commandState = state;
				RequestHistory.getInstance().mHistory.add(historyLine);
			}
		}
		return message;
	}
}
