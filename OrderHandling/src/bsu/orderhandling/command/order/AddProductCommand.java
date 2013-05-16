package bsu.orderhandling.command.order;

import bsu.orderhandling.command.Command;
import bsu.orderhandling.command.UserMessage;
import bsu.orderhandling.order.Order;

public class AddProductCommand extends Command {
	private static AddProductCommand instance = null;
	protected AddProductCommand() {}
	public static synchronized AddProductCommand getInstance() {
		if (instance == null) {
			instance = new AddProductCommand();
		}
		return instance;
	}
	
	@Override
	public UserMessage execute() {
		CommandMemento state = (CommandMemento) getState();
		Order order = (Order) state.params.get(CommandMemento.ORDER);
		return order.addProduct();
	}

	@Override
	public UserMessage revert() {
		CommandMemento state = (CommandMemento) getState();
		Order order = (Order) state.params.get(CommandMemento.ORDER);
		return order.removeProduct();
	}
}
