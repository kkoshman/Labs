package bsu.orderhandling.request;

import java.util.Map;

public class Request {
	public static final String ORDER = "order";
	public static final String PRODUCT = "product";
	public static final String QUANTITY = "qty";
	public static final String SHIPPING_INFO = "shipInfo";
	public static final String BILLING_INFO = "billInfo";
	
	public String action;
	public Map<String, Object> params;
}
