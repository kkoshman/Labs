package bsu.orderhandling.order.state;

import bsu.orderhandling.command.UserMessage;
import bsu.orderhandling.command.UserMessageType;
import bsu.orderhandling.order.Order;

public class EmptyOrderState extends BasicOrderState {
	private static EmptyOrderState instance = null;
	protected EmptyOrderState() {}
	public static synchronized EmptyOrderState getInstance() {
		if (instance == null) {
			instance = new EmptyOrderState();
		}
		return instance;
	}
	
	@Override
	public UserMessage addProduct(Order pOrder) {
		UserMessage message = new UserMessage();
		if (pOrder != null) {
			pOrder.setProductQuantity(1);
			message.setMessage("You've successfully added product");
			message.setType(UserMessageType.SUCCESS);
			pOrder.setOrderState(NotEmptyOrderState.getInstance());
		} else {
			message.setMessage("You have no order");
			message.setType(UserMessageType.ERROR);
		}
		return message;
	}
}
