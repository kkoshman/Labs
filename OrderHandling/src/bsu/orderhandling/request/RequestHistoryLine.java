package bsu.orderhandling.request;

import bsu.orderhandling.command.Command;
import bsu.orderhandling.command.ICommandState;

public class RequestHistoryLine {
	public Request request;
	public Command command;
	public ICommandState commandState;
}
