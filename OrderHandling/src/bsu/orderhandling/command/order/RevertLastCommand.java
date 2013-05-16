package bsu.orderhandling.command.order;

import bsu.orderhandling.command.Command;
import bsu.orderhandling.command.UserMessage;
import bsu.orderhandling.command.UserMessageType;
import bsu.orderhandling.request.RequestHistory;
import bsu.orderhandling.request.RequestHistoryLine;

public class RevertLastCommand extends Command {
	private static RevertLastCommand instance = null;
	protected RevertLastCommand() {}
	public static synchronized RevertLastCommand getInstance() {
		if (instance == null) {
			instance = new RevertLastCommand();
		}
		return instance;
	}
	
	@Override
	public UserMessage execute() {
		RequestHistory history = RequestHistory.getInstance();
		int size = history.mHistory.size();
		RequestHistoryLine line = history.mHistory.get(size - 1);
		Command command = line.command;
		if (command != null) {
			command.setState(line.commandState);
			command.revert();
			history.mHistory.remove(line);
		}
		UserMessage message = new UserMessage();
		message.setMessage("You've successfully revert last action");
		message.setType(UserMessageType.SUCCESS);
		return message;
	}

	@Override
	public UserMessage revert() {
		UserMessage message = new UserMessage();
		message.setMessage("You cant revert this action");
		message.setType(UserMessageType.INFO);
		return message;
	}

}
