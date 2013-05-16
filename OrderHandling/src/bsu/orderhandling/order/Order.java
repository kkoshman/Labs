package bsu.orderhandling.order;

import bsu.orderhandling.command.UserMessage;
import bsu.orderhandling.order.state.EmptyOrderState;

public class Order {
	protected OrderState mOrderState;
	protected int mProductQuantity;
	
	public OrderState getOrderState() {
		return mOrderState;
	}
	public void setOrderState(OrderState orderState) {
		mOrderState = orderState;
	}


	public int getProductQuantity() {
		return mProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		mProductQuantity = productQuantity;
	}
	public Order() {
		setOrderState(EmptyOrderState.getInstance());
	}
	public UserMessage addProduct() {
		return getOrderState().addProduct(this);
	}
	public UserMessage removeProduct() {
		return getOrderState().removeProduct(this);
	}
	public UserMessage addShippingInfo(ShippingInfo pShippingInfo) {
		return getOrderState().addShippingInfo(this, pShippingInfo);
	}
	public UserMessage addBillingInfo(BillingInfo pBillingInfo) {
		return getOrderState().addBillingInfo(this, pBillingInfo);
	}
	public UserMessage calculateOrderAmount() {
		return getOrderState().calculateOrderAmount(this);
	}
	public UserMessage confirmOrder() {
		return getOrderState().confirmOrder(this);
	}
	public UserMessage cancelOrder() {
		return getOrderState().cancelOrder(this);
	}
	public UserMessage shipOrderProducts() {
		return getOrderState().shipOrderProducts(this);
	}
	public UserMessage returnOrderProducts() {
		return getOrderState().returnOrderProducts(this);
	}
}
