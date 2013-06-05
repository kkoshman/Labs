package bsu.webapp.request;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import bsu.orderhandling.command.Command;
import bsu.orderhandling.command.UserMessage;
import bsu.orderhandling.command.order.AddProductCommand;
import bsu.orderhandling.request.Request;
import bsu.webapp.util.Constants;

public class ViewHandler {
	public static final String ADD_PRODUCT = "addProduct";
	
	private static ViewHandler instance = null;
	
	protected ViewHandler() {
		mCommandsMap = new HashMap<String, Command>();
		mCommandsMap.put(ADD_PRODUCT, AddProductCommand.getInstance());
	}
	public static synchronized ViewHandler getInstance() {
		if (instance == null) {
			instance = new ViewHandler();
		}
		return instance;
	}
	
	protected Map<String, Command> mCommandsMap;
		
	public UserMessage handleRequest(Request pRequest) {
		UserMessage message = null;
		String commandName = pRequest.action;
		Command command = mCommandsMap.get(commandName);
		if (command != null) {
			command.execute();
		}
		return message;
	}
}
