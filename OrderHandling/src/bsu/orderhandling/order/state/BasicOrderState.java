package bsu.orderhandling.order.state;


import bsu.orderhandling.command.UserMessage;
import bsu.orderhandling.command.UserMessageType;
import bsu.orderhandling.order.BillingInfo;
import bsu.orderhandling.order.Order;
import bsu.orderhandling.order.OrderState;
import bsu.orderhandling.order.ShippingInfo;

public class BasicOrderState extends OrderState {
	private static BasicOrderState basicOrderStateInstance = null;
	protected BasicOrderState() {}
	public static synchronized BasicOrderState getInstance() {
		if (basicOrderStateInstance == null) {
			basicOrderStateInstance = new BasicOrderState();
		}
		return basicOrderStateInstance;
	}
	
	@Override
	public UserMessage addShippingInfo(Order pOrder, ShippingInfo pShippingInfo) {
		UserMessage message = new UserMessage();
		message.setMessage("You cannot execute this operation");
		message.setType(UserMessageType.ERROR);
		return message;
	}

	@Override
	public UserMessage addBillingInfo(Order pOrder, BillingInfo pBillingInfo) {
		UserMessage message = new UserMessage();
		message.setMessage("You cannot execute this operation");
		message.setType(UserMessageType.ERROR);
		return message;
	}

	@Override
	public UserMessage calculateOrderAmount(Order pOrder) {
		UserMessage message = new UserMessage();
		message.setMessage("You cannot execute this operation");
		message.setType(UserMessageType.ERROR);
		return message;
	}

	@Override
	public UserMessage confirmOrder(Order pOrder) {
		UserMessage message = new UserMessage();
		message.setMessage("You cannot execute this operation");
		message.setType(UserMessageType.ERROR);
		return message;
	}

	@Override
	public UserMessage cancelOrder(Order pOrder) {
		UserMessage message = new UserMessage();
		message.setMessage("You cannot execute this operation");
		message.setType(UserMessageType.ERROR);
		return message;
	}

	@Override
	public UserMessage shipOrderProducts(Order pOrder) {
		UserMessage message = new UserMessage();
		message.setMessage("You cannot execute this operation");
		message.setType(UserMessageType.ERROR);
		return message;
	}

	@Override
	public UserMessage returnOrderProducts(Order pOrder) {
		UserMessage message = new UserMessage();
		message.setMessage("You cannot execute this operation");
		message.setType(UserMessageType.ERROR);
		return message;
	}
	@Override
	public UserMessage addProduct(Order pOrder) {
		UserMessage message = new UserMessage();
		message.setMessage("You cannot execute this operation");
		message.setType(UserMessageType.ERROR);
		return message;
	}
	@Override
	public UserMessage removeProduct(Order pOrder) {
		UserMessage message = new UserMessage();
		message.setMessage("You cannot execute this operation");
		message.setType(UserMessageType.ERROR);
		return message;
	}

}
