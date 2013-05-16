package bsu.orderhandling.order.state;

import bsu.orderhandling.command.UserMessage;
import bsu.orderhandling.command.UserMessageType;
import bsu.orderhandling.order.Order;

public class NotEmptyOrderState extends BasicOrderState {
	private static NotEmptyOrderState instance = null;
	protected NotEmptyOrderState() {}
	public static synchronized NotEmptyOrderState getInstance() {
		if (instance == null) {
			instance = new NotEmptyOrderState();
		}
		return instance;
	}
	
	@Override
	public UserMessage addProduct(Order pOrder) {
		UserMessage message = new UserMessage();
		if (pOrder != null) {
			int qty = pOrder.getProductQuantity() + 1;
			pOrder.setProductQuantity(qty);
			message.setMessage("You've successfully added product");
			message.setType(UserMessageType.SUCCESS);
		} else {
			message.setMessage("You have no order");
			message.setType(UserMessageType.ERROR);
		}
		return message;
	}
	
	@Override
	public UserMessage removeProduct(Order pOrder) {
		UserMessage message = new UserMessage();
		if (pOrder != null) {
			int qty = pOrder.getProductQuantity() - 1;
			pOrder.setProductQuantity(qty);
			message.setMessage("You've successfully removed product");
			message.setType(UserMessageType.SUCCESS);
			if (qty == 0) {
				pOrder.setOrderState(EmptyOrderState.getInstance());
			}
		} else {
			message.setMessage("You have no order");
			message.setType(UserMessageType.ERROR);
		}
		return message;
	}
}
