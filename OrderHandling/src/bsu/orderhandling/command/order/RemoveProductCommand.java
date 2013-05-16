package bsu.orderhandling.command.order;

import bsu.orderhandling.command.Command;
import bsu.orderhandling.command.UserMessage;
import bsu.orderhandling.order.Order;

public class RemoveProductCommand extends Command {
	private static RemoveProductCommand instance = null;
	protected RemoveProductCommand() {}
	public static synchronized RemoveProductCommand getInstance() {
		if (instance == null) {
			instance = new RemoveProductCommand();
		}
		return instance;
	}

	@Override
	public UserMessage revert() {
		CommandMemento state = (CommandMemento) getState();
		Order order = (Order) state.params.get(CommandMemento.ORDER);
		return order.addProduct();
	}

	@Override
	public UserMessage execute() {
		CommandMemento state = (CommandMemento) getState();
		Order order = (Order) state.params.get(CommandMemento.ORDER);
		return order.removeProduct();
	}

}
