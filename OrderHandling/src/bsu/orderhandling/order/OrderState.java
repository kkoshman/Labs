package bsu.orderhandling.order;

import bsu.orderhandling.command.UserMessage;

public abstract class OrderState {
	public abstract UserMessage addProduct(Order pOrder);
	public abstract UserMessage removeProduct(Order pOrder);
	public abstract UserMessage addShippingInfo(Order pOrder, ShippingInfo pShippingInfo);
	public abstract UserMessage addBillingInfo(Order pOrder, BillingInfo pBillingInfo);
	public abstract UserMessage calculateOrderAmount(Order pOrder);
	public abstract UserMessage confirmOrder(Order pOrder);
	public abstract UserMessage cancelOrder(Order pOrder);
	public abstract UserMessage shipOrderProducts(Order pOrder);
	public abstract UserMessage returnOrderProducts(Order pOrder);

}
