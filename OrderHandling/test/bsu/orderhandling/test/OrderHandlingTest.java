package bsu.orderhandling.test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import bsu.orderhandling.command.Command;
import bsu.orderhandling.command.order.AddProductCommand;
import bsu.orderhandling.command.ICommandState;
import bsu.orderhandling.command.UserMessage;
import bsu.orderhandling.command.UserMessageType;
import bsu.orderhandling.order.Order;
import bsu.orderhandling.request.Request;
import bsu.orderhandling.request.RequestHandler;

public class OrderHandlingTest {

	@Test
	public void test() {
		Order order = new Order();
		RequestHandler handler = RequestHandler.getInstance();
		UserMessage message = null;
		
		Request request = new Request();
		request.action = RequestHandler.ADD_PRODUCT;
		request.params = new HashMap<String, Object>();
		request.params.put(Request.ORDER, order);
		message = handler.handleRequest(request);
		System.out.println(message);
		assertTrue(order.getProductQuantity() == 1);
		
		request = new Request();
		request.action = RequestHandler.REMOVE_PRODUCT;
		request.params = new HashMap<String, Object>();
		request.params.put(Request.ORDER, order);
		message = handler.handleRequest(request);
		System.out.println(message);
		assertTrue(order.getProductQuantity() == 0);
		
		request = new Request();
		request.action = RequestHandler.REMOVE_PRODUCT;
		request.params = new HashMap<String, Object>();
		request.params.put(Request.ORDER, order);
		message = handler.handleRequest(request);
		System.out.println(message);
		assertTrue(message.getType() == UserMessageType.ERROR);
		assertTrue(order.getProductQuantity() == 0);
		
		request = new Request();
		request.action = RequestHandler.REVERT_LAST_COMMAND;
		request.params = new HashMap<String, Object>();
		message = handler.handleRequest(request);
		System.out.println(message);
		assertTrue(message.getType() == UserMessageType.SUCCESS);
		assertTrue(order.getProductQuantity() == 1);
		
	}
	
	@Test
	public void testMemento() {
		Command command = AddProductCommand.getInstance();
		ICommandState state = command.returnState(null);
		// ICommandState interface have no methods
		// and you have not access to class Command.CommandMemento
		//state = (Command.CommandMemento)state; //compilation error
		// then you cannot get or update inner memento data from the outside Command class
	}

}
